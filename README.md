# 🛒 Sistema de Gestión de Pedidos con Spring Boot y Kafka

## 📌 Descripción del Proyecto

Este proyecto es una solución completa para la **gestión de pedidos** desarrollada con tecnologías modernas como **Spring Boot**, **Apache Kafka**, **JPA (Hibernate)** y **PostgreSQL**. El sistema permite administrar usuarios, productos y pedidos de forma segura, eficiente y escalable.

Se implementa una arquitectura basada en **MVC**, junto con **Spring Security + JWT** para autenticación y autorización basada en roles (usuario y administrador). Además, se utiliza **Apache Kafka** para el manejo asincrónico de eventos relacionados con los pedidos (creación, actualización, cancelación).

Todo el entorno del proyecto ya está completamente **dockerizado** para que puedas levantarlo con un solo comando y empezar a trabajar sin complicaciones.

---

## 🚀 Características Principales

- ✅ **Gestión de Usuarios**: Registro, login y autenticación vía JWT.
- 🛍️ **Gestión de Productos**: CRUD completo con validaciones.
- 📦 **Gestión de Pedidos**: Control de stock, creación, actualización, eliminación de pedidos.
- 🔄 **Comunicación Asincrónica con Kafka**: Notificación automática de eventos de pedidos.
- 🧾 **Persistencia con PostgreSQL**.
- 🔐 **Control de Acceso con Spring Security**.
- 📬 **Pruebas de Endpoints con Postman**.

---

## ⚙️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Security + JWT**
- **Apache Kafka**
- **JPA (Hibernate)**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Postman**

---

## 🏗️ Estructura de la Base de Datos

> Aquí se muestra un esquema relacional de las tablas:

![Esquema de la Base de Datos](https://github.com/user-attachments/assets/fbfd6828-96a4-4dcf-beb5-875b2b25589d)

---

## 🎯 Objetivos del Proyecto

- Desarrollar una solución escalable y segura para la gestión de pedidos.
- Aplicar buenas prácticas como los principios **SOLID** y arquitectura limpia.
- Integrar tecnologías modernas como Kafka para comunicación asincrónica.
- Proporcionar una experiencia de desarrollo sencilla con entornos ya preconfigurados.
- Documentar y probar de forma clara los endpoints disponibles.

---

## 🐳 Puesta en Marcha con Docker Compose

¡Todo ya está configurado! No necesitas instalar bases de datos ni servicios adicionales manualmente. Solo sigue estos pasos:

1. Clona el repositorio:
   ```bash
   git clone https://github.com/msxd26/gestion_de_pedidos.git
   cd gestion_de_pedidos```
2. Levanta todos los servicios (backend, base de datos, kafka, zookeeper) con un solo comando:
   ```bash
   docker compose up -d```

4. 
