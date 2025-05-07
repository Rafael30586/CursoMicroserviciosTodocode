package com.todocodeacademy.destinatarios.repository;

import com.todocodeacademy.destinatarios.dto.EnvioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="envios",url="http://localhost:9001/envios")
public interface IEnvioClient {

    @GetMapping("/por-destinatario/{idDestinatario}")
    public List<EnvioDTO> traerEnviosPorDestinatario(@PathVariable Long idDestinatario);
}
