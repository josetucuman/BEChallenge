# BEChallenge

Este repositorio contiene DOS resoluciones del problema que era consumir una API, que va a traer los directores que se requieran.

Voy a describir a ambas resoluciones:
##BEChallengeMaster
Para BEChallengeMaster el pueerto es 9393,
Se usa Http Client, y ObjectMapper. pueden ver la configuracion en .env, pues esta configurada para tomar las variables de entorno.

##BEChallengeMasterFeign
# Movie Directors API

Este proyecto es una API desarrollada con Spring Boot para obtener datos de directores de películas. Utiliza `HttpClient` para hacer solicitudes HTTP y recupera la información desde una API externa.

## Tabla de Contenidos

- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Endpoints de la API](#endpoints-de-la-api)
- [Ejemplos de Solicitudes y Respuestas](#ejemplos-de-solicitudes-y-respuestas)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- Java 11 o superior
- Maven
- Un entorno de desarrollo como IntelliJ IDEA o Eclipse

## Instalación

Sigue estos pasos para configurar y ejecutar el proyecto localmente.

1. **Clonar el repositorio:**

    ```sh
    git clone <URL_DEL_REPOSITORIO>
    cd movie-directors-api
    ```

2. **Configurar las propiedades de la aplicación:**

    Edita el archivo `src/main/resources/application.properties` y configura la URL de la API externa:

    ```properties
    url.http.request=https://example.com/api/movies?page=
    ```

3. **Construir el proyecto:**

    ```sh
    ./mvnw clean install
    ```

4. **Ejecutar la aplicación:**

    ```sh
    ./mvnw spring-boot:run
    ```

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a los endpoints disponibles utilizando herramientas como `Postman` o `curl`.

### Endpoints de la API

#### Obtener Directores

- **URL:** `/api/v1/directors`
- **Método:** `GET`
- **Parámetros de Consulta:**
  - `threshold` (int): El umbral mínimo de películas dirigidas por el director.

#### Ejemplo de Solicitud

```sh
curl -X GET "http://localhost:9596/api/v1/directors?threshold=2"

{
    "directors": [
        "Quentin Tarantino",
        "Martin Scorsese",
        "Woody Allen"
    ]
}

movie-directors-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/b2bSolutions/core/HTTPCLIENTS/
│   │   │       ├── config/
│   │   │       │   └── HttpClientConfig.java
│   │   │       ├── controller/
│   │   │       │   └── MovieController.java
│   │   │       ├── dtos/
│   │   │       │   ├── Movie.java
│   │   │       │   └── MovieResponse.java
│   │   │       ├── repository/
│   │   │       │   ├── MovieRepository.java
│   │   │       │   └── impl/
│   │   │       │       └── MovieRepositoryImpl.java
│   │   │       ├── service/
│   │   │       │   ├── MovieService.java
│   │   │       │   └── impl/
│   │   │       │       └── MovieServiceImpl.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md
```
# Movie Directors API con Feign

Este proyecto es una API desarrollada con Spring Boot que utiliza Feign para hacer solicitudes HTTP y obtener datos de directores de películas desde una API externa.

## Tabla de Contenidos

- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Endpoints de la API](#endpoints-de-la-api)
- [Ejemplos de Solicitudes y Respuestas](#ejemplos-de-solicitudes-y-respuestas)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- Java 11 o superior
- Maven
- Un entorno de desarrollo como IntelliJ IDEA o Eclipse

## Instalación

Sigue estos pasos para configurar y ejecutar el proyecto localmente.

1. **Clonar el repositorio:**

    ```sh
    git clone <URL_DEL_REPOSITORIO>
    cd movie-directors-api
    ```

2. **Configurar las propiedades de la aplicación:**

    Edita el archivo `src/main/resources/application.properties` y configura la URL de la API externa:

    ```properties
    url.http.request=https://example.com/api/movies?page=
    ```

3. **Construir el proyecto:**

    ```sh
    ./mvnw clean install
    ```

4. **Ejecutar la aplicación:**

    ```sh
    ./mvnw spring-boot:run
    ```

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a los endpoints disponibles utilizando herramientas como `Postman` o `curl`.

### Endpoints de la API

#### Obtener Directores

- **URL:** `/api/v2/directors`
- **Método:** `GET`
- **Parámetros de Consulta:**
  - `threshold` (int): El umbral mínimo de películas dirigidas por el director.

#### Ejemplo de Solicitud

```sh
curl -X GET "http://localhost:9596/api/v2/directors?threshold=2"
```
### Ejemplo de respuesta
```sh
[
    "Quentin Tarantino",
    "Martin Scorsese",
    "Woody Allen"
]
```
###Estructura del Proyecto
```sh
movie-directors-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/josegelimergomez/core/
│   │   │       ├── client/
│   │   │       │   └── DirectorFeignClient.java
│   │   │       ├── config/
│   │   │       │   └── FeignConfig.java
│   │   │       ├── controller/
│   │   │       │   └── MovieController.java
│   │   │       ├── dto/
│   │   │       │   └── MovieResponse.java
│   │   │       ├── exception/
│   │   │       │   ├── ApiException.java
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   ├── ResourceNotFoundException.java
│   │   │       ├── service/
│   │   │       │   ├── MovieService.java
│   │   │       └── util/
│   │   │           └── CustomDecoder.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md
```
