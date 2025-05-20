FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/carrito-de-compras-0.0.1.jar
COPY ${JAR_FILE} app_carrito-de-compras.jar
ENTRYPOINT ["java","-jar","app_carrito-de-compras.jar"]