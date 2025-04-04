# Sistema de Gestión de Pedidos con Spring Boot y Kafka

## Descripción del Proyecto

Este proyecto es un sistema de gestión de pedidos desarrollado con un stack tecnológico moderno basado en **Spring Boot**, **Apache Kafka**, **JPA (Hibernate)** y **PostgreSQL**. Su objetivo principal es proporcionar una solución eficiente y segura para la gestión de usuarios, productos y pedidos, implementando una arquitectura **MVC** que asegura un código organizado y mantenible. 

El sistema incluye autenticación y autorización mediante **JWT** y **Spring Security**, permitiendo un control de acceso basado en roles (usuario y administrador). Además, utiliza **Kafka** para la comunicación asincrónica, enviando notificaciones sobre cambios en los pedidos (creación, modificación, cancelación). La persistencia de datos se realiza en una base de datos **PostgreSQL**, y las funcionalidades están documentadas y probadas con **Postman**.

### Funcionalidades Principales
- **Gestión de Usuarios**: Registro, inicio de sesión y autenticación segura con JWT.
- **Gestión de Productos**: Operaciones CRUD (Crear, Leer, Actualizar, Eliminar) con validaciones de negocio.
- **Gestión de Pedidos**: Creación, modificación y eliminación de pedidos, con control de stock y notificaciones asincrónicas.
- **Comunicación Asincrónica**: Uso de Kafka para notificar eventos relacionados con los pedidos.

### Tecnologías Utilizadas
- **Spring Boot**: Framework principal para el desarrollo del backend.
- **JPA (Hibernate)**: Persistencia de datos con mapeo objeto-relacional.
- **Apache Kafka**: Comunicación asincrónica y manejo de eventos.
- **Spring Security + JWT**: Seguridad y control de acceso.
- **PostgreSQL**: Base de datos relacional.
- **Postman**: Pruebas y documentación de APIs.

## Estructura de la Base de Datos
A continuación se muestra el esquema de la relación de tablas:

![Esquema de la Base de Datos](https://github.com/user-attachments/assets/fbfd6828-96a4-4dcf-beb5-875b2b25589d)

## Objetivos del Proyecto
- Implementar un sistema escalable y seguro para la gestión de pedidos.
- Aplicar principios de diseño como SOLID para garantizar un código limpio y mantenible.
- Integrar tecnologías modernas como Kafka para manejar procesos asincrónicos.
- Proporcionar una documentación clara y pruebas funcionales de los endpoints.

## Cómo Clonar el Repositorio
Para clonar este repositorio y comenzar a trabajar con el proyecto, sigue estos pasos:

1. Asegúrate de tener instalado **Git** en tu máquina.
2. Abre una terminal y ejecuta el siguiente comando:
   ```bash
   git clone https://github.com/msxd26/gestion_de_pedidos.git
   ```

3. Navega al directorio del proyecto:
   ```bash
   cd gestion_de_pedidos
   ```
4. Configura las dependencias y la conexión a la base de datos en el archivo `application.properties` o `application.yml`.
5. Ejecuta el proyecto con:
   ```bash
   ./mvnw spring-boot:run
   ```


