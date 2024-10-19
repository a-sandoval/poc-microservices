# Ejemplo Arquitectura de Microservicios en Java 17 - Sistema de Órdenes y Productos

Este proyecto muestra cómo crear microservicios simples con Spring Boot y permitiendo su conexión entre sí mediante Spring Cloud, sumado a la utilización de Eureka para implementar un Service Registry y Spring Cloud Gateway como API Gateway.

## Arquitectura
El proyecto sigue un estilo arquitectónico de microservicios. Se tienen dos microservicios (Órdenes y Productos) que se registran a sí mismos en el Service Discovery (implementado con Eureka Server) y se comunican entre sí mediante un cliente REST (Open Feign). Todo el sistema se esconde detrás del API Gateway.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3**
- **Spring Data JPA** (para interacción con la base de datos)
- **Maven** (gestor de dependencias)
- **Lombok** (para reducir el código boilerplate)
- **MySQL**
- **Spring Cloud Netflix Eureka**
- **Spring Cloud Gateway**
- **Spring Cloud Netflix Feign**

## Pasos para Ejecución del Proyecto

- **1.** Clonar la aplicación.
- **2.** Cambiar los puertos para las aplicaciones como prefiera. Para eso abrir en los proyectos  `src/main/resources/application.properties` y cambiar la propiedad `server.port`. Para el API Gateway se puede cambiar el producto defecto abriendo el archivo  `src/main/resources/application.yml` y cambiar la propiedad `server.port`.
- **3.** Correr el Service Registry & Discovery. Iniciará en el puerto `8761` por defecto. Una vez que inicies la aplicación podrás visitar el *dashboard* de Eureka bajo  `http://localhost:8761`.
- **4.** Correr los microservicios de Productos y de Órdenes.
- **5.** Correr el API Gateway. Este permitirá redirigir cualquier solicitud al microservicio específico dependiendo de la configuración del *proxy*. 