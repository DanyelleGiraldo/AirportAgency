# AirportAgency

# GLOBAL_FLIGHTS

## TECNOLOGÍAS EMPLEADAS

### JAVA
Java es un lenguaje de programación orientado a objetos y una plataforma esencial para desarrollar aplicaciones. En este proyecto, Java se utiliza para interactuar con la base de datos, gestionar la lógica de negocio y controlar el flujo de la aplicación.

#### Ejemplos de Aplicación:
- **Conexión a la Base de Datos:** Utilización de JDBC (Java Database Connectivity) para conectar y ejecutar operaciones en una base de datos MySQL.
- **Servicios y Repositorios:** Implementación de servicios para manejar la lógica de negocio y repositorios para gestionar la persistencia de datos.

### MySQL
MySQL es un sistema de gestión de bases de datos relacional de código abierto que emplea SQL (Structured Query Language) para la gestión y manipulación de datos.

#### Ejemplos de Aplicación:
- **Definición de Esquemas y Tablas:** Creación de estructuras de datos mediante sentencias DDL (Data Definition Language).
- **Consultas y Transacciones:** Realización de operaciones como inserciones, actualizaciones, eliminaciones y consultas utilizando sentencias DML (Data Manipulation Language).
- **Mantenimiento de la Integridad de Datos:** Aplicación de restricciones como claves primarias, claves foráneas, índices y reglas de unicidad.

#### Ejemplos de Aplicación:
- **Manejo de Dependencias:** Declaración de librerías externas y plugins necesarios en el archivo `pom.xml`.
- **Compilación del Proyecto:** Uso de comandos Maven para compilar, ejecutar pruebas y empaquetar la aplicación.
- **Gestión de Perfiles:** Configuración de perfiles para distintos entornos (desarrollo, pruebas, producción).

## ESTRUCTURA

### Arquitectura Hexagonal
La arquitectura hexagonal es un patrón de diseño de software que promueve la separación de responsabilidades y la independencia de la infraestructura. La lógica de negocio se mantiene en el núcleo (dominio) y las interacciones externas (interfaces de usuario, bases de datos, servicios externos) se manejan mediante puertos y adaptadores.

### Slicing Vertical
Esta técnica de desarrollo divide la aplicación en componentes completos de funcionalidad, atravesando todas las capas de la arquitectura, desde la interfaz de usuario hasta la base de datos. Cada "slice" representa una funcionalidad autónoma.

#### Ejemplos de Aplicación:
- **Funcionalidad Completa:** Implementación de una característica específica (por ejemplo, gestión de vuelos) que incluye cambios en la base de datos, lógica de negocio y la interfaz de usuario.
- **Desarrollo Iterativo:** Implementación de funcionalidades de manera iterativa, asegurando que cada slice esté completamente funcional antes de avanzar al siguiente.


## FUNCIONALIDADES

Esta aplicación permite gestionar la base de datos de una aerolínea, proporcionando operaciones CRUD para cada entidad establecida y asegurando la integridad y normalización hasta la 4ª forma normal. Dependiendo del rol del usuario, se habilitan diferentes casos de uso y responsabilidades.



