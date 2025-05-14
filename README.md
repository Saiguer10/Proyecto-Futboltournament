# **FUTBOLTOURNAMENT API REST**

-------------------------------------------
## **Descripción del proyecto**

Este proyecto es una **API REST** desarrollada con **Java y Spring Boot**, 
que permite gestionar ligas de fútbol amateur. 
Proporciona funcionalidades para crear y administrar equipos, jugadores y partidos, 
con autenticación JWT para asegurar el acceso a los endpoints. 
Se ha aplicado herencia JPA para diferenciar entre distintos 
tipos de usuarios,y se utiliza MySQL como base de datos principal.


## **Diagrama de Clases UML**

 A continuación se muestra el modelo de diagrama del proyecto:

![Diagrama UML proyecto.JPG](Diagrama%20UML%20proyecto.JPG)

## **Configuración**

- Crear y clonar repositorio de GitHub (git clone)
- Configurar las propiedades de la aplicación en Intellij
- Conexión con BBDD MySQL con usuario y contraseña

## **Tecnologías utilizadas**
A lo largo del proyecto, hemos requerido el uso de diversas tecnologías a destacar:

- Java 21
- Spring Security (Test+Jwt )
- Spring Boot (Startet web, data-jpa, Validation, Security, Test, Devtools)
- JUnit 5 + MockMvc (Testeo)
- Maven (Builder Construct)
- BBDD MySQL
- Lombok


## **Estructura de controladores y rutas**

A continuacion se muestran los endpoints principales del proyecto:

| Método | Endpoint            | Descripción                    |
| ------ |---------------------|--------------------------------|
| GET    | `/api/teams`        | Listar todos los equipos       |
| POST   | `/api/teams`        | Crear un nuevo equipo          |
| GET    | `/teams/{id}`       | Obtener un equipo concreto     |
| PUT    | `/teams/{id}`       | Actualizar un equipo existente |
| DELETE | `/teams/{id}`       | Eliminar un equipo             |
| POST   | `/api/players`      | Crear un nuevo jugador         |
| POST   | `/api/auth/matches` | Crear un partido               |


## **Enlaces adicionales**


### **Gestion del proyecto y planificación**:

#### **[Trello - Proyecto Futboltournament](https://trello.com/b/nlYE3hv4/futboltournament)**

### **Presentacion del proyecto** 

#### **[Proyecto FutbolTournament](https://docs.google.com/presentation/d/1lFoFhgg9-yilI74bDs9YYo0diftuCKJ3PnLxPnx8FcI/edit?usp=sharing)**




## **Trabajo futuro**

- Creación de ligas
- Desarrollo Frontend
- Mejoras de seguridad


## **Recursos**

- [Spring Boot Documents]([https://spring.io/projects/spring-boot)
- [Lombok guide]((https://projectlombok.org/features/all))
- [JWT Spring Security]((https://www.baeldung.com/spring-security-oauth-jwt)  )
- [Testing JUnit 5]((https://www.baeldung.com/spring-boot-testing))


## **Miembros del equipo**
Proyecto desarrollado por **Jose Manuel Siguero Perez**
- [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?logo=linkedin)](https://www.linkedin.com/in/jose-manuel-siguero/)

-----------------------------------------------------------------------------------

¡ Gracias !



