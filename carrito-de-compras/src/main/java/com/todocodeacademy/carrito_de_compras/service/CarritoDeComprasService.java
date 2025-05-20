package com.todocodeacademy.carrito_de_compras.service;

import com.todocodeacademy.carrito_de_compras.dto.CantidadProductoDTO;
import com.todocodeacademy.carrito_de_compras.model.CarritoDeCompras;
import com.todocodeacademy.carrito_de_compras.repository.ICarritoDeComprasRepository;
import com.todocodeacademy.carrito_de_compras.repository.IProductoClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoDeComprasService implements ICarritoDeComprasService{

    @Autowired
    private ICarritoDeComprasRepository repository;
    @Autowired
    private IProductoClient productoClient;

    @Override
    public List<CarritoDeCompras> traerTodos() {
        return repository.findAll();
    }

    @Override
    public CarritoDeCompras traerPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CarritoDeCompras modificar(Long id, CarritoDeCompras carritoDeCompras) {
        this.crear(carritoDeCompras);
        return repository.findById(id).get();
    }

    @Override
    public void crear(CarritoDeCompras carritoDeCompras) {
        repository.save(carritoDeCompras);
    }

    @Override
    @CircuitBreaker(name="productos", fallbackMethod = "fallback")
    @Retry(name="productos")
    public CarritoDeCompras agregarProducto(Long idProducto,int cantidadProducto,Long idCarritoDeCompras) {
        int index = 0;
        CarritoDeCompras carritoDeCompras = this.traerPorId(idCarritoDeCompras);
        List<CantidadProductoDTO> listaProductos = carritoDeCompras.getListaProductos();
        CantidadProductoDTO cantidadProductoDTO = new CantidadProductoDTO();
        cantidadProductoDTO.setProductoId(idProducto);
        cantidadProductoDTO.setCantidadProducto(cantidadProducto);

        for(CantidadProductoDTO p : listaProductos){

            if(p.getProductoId().equals(idProducto)) {
                listaProductos.remove(index);
                //aca hay que restar el dinero que cuesta el producto que sacamos
                carritoDeCompras.setPrecioTotal(carritoDeCompras.getPrecioTotal()-productoClient.traerPorId(p.getProductoId()).getPrecioIndividual()*p.getCantidadProducto());
            }
            index++;
        }

        listaProductos.add(cantidadProductoDTO);

        carritoDeCompras.setPrecioTotal(carritoDeCompras.getPrecioTotal()+productoClient.traerPorId(idProducto).getPrecioIndividual()*cantidadProductoDTO.getCantidadProducto());
        carritoDeCompras.setListaProductos(listaProductos);
        this.crear(carritoDeCompras);

        return this.traerPorId(idCarritoDeCompras);
    }

    public CarritoDeCompras fallback(){
        return new CarritoDeCompras(999999999L,0.0,new ArrayList<CantidadProductoDTO>());
    }

    @Override
    public void quitarProducto(Long idProducto, Long idCarritoDeCompras) {
        CarritoDeCompras carritoDeCompras = this.traerPorId(idCarritoDeCompras);
        List<CantidadProductoDTO> listaProductos = carritoDeCompras.getListaProductos();

        for(CantidadProductoDTO p : listaProductos){
            if(p.getProductoId().equals(idProducto)){
                listaProductos.remove(listaProductos.indexOf(p.getProductoId()));
                carritoDeCompras.setPrecioTotal(carritoDeCompras.getPrecioTotal()-productoClient.traerPorId(idProducto).getPrecioIndividual()*p.getCantidadProducto());
                break;
            }
        }


    }

}
