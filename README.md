# ⚙️ CarhPay - API RESTful Backend

![Estado](https://img.shields.io/badge/Estado-En_Desarrollo-green)
![Java](https://img.shields.io/badge/Backend-Java_Spring_Boot-007396?logo=java)
![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?logo=mysql)

## 📌 Descripción del Proyecto
Este repositorio contiene el núcleo de lógica de negocio (Backend) de **CarhPay**. Es una API RESTful construida con Spring Boot que gestiona de manera segura la base de datos de clientes, el catálogo de servicios, las reglas de negocio y el motor de generación dinámica de recibos en formato PDF.

## ✨ Características Principales
* **Arquitectura de Capas Limpia:** Separación estricta de responsabilidades usando Controladores, Servicios y Repositorios (Principios SOLID).
* **Patrón DTO (Data Transfer Object):** Desacoplamiento de las entidades de base de datos (`Cliente`, `Servicio`, `Recibo`) de las peticiones HTTP, garantizando seguridad y código limpio.
* **Motor de Generación PDF:** Integración con `OpenPDF` para crear recibos por honorarios electrónicos al vuelo. El diseño utiliza estructuras de grillas (tables) para alinear los datos de forma profesional.
* **Integridad Relacional y Reglas de Negocio:** Manejo estricto de restricciones de base de datos (`DataIntegrityViolationException`) para proteger el historial financiero.
* **CORS Configurado:** Listo para comunicarse de forma segura con aplicaciones cliente modernas.

## 🛠️ Stack Tecnológico
* **Lenguaje & Framework:** Java 17+ y Spring Boot 3
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL
* **Generación de Documentos:** OpenPDF
* **Herramientas:** Lombok (Reducción de código repetitivo)

## 🚀 Instalación y Despliegue

### Requisitos Previos
* Java Development Kit (JDK) 17 o superior.
* MySQL Server ejecutándose en el puerto 3306.
* Maven.

### Pasos para ejecutar
1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/ArturoRoncal2704/facturacion-api.git](https://github.com/ArturoRoncal2704/facturacion-api.git)
   ```
2. Configurar la Base de Datos:
   ```bash
   Crea una base de datos en MySQL llamada facturacion_db.
   ```
3. Actualizar credenciales:
   ```bash
   Asegúrate de que el archivo src/main/resources/application.properties tenga tu usuario y contraseña de MySQL.
   spring.datasource.url=jdbc:mysql://localhost:3306/facturacion_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```
4. Compilar y ejecutar (Hibernate creará las tablas automáticamente):
   ```bash
   ./mvnw spring-boot:run
   ```
5. La API estará disponible en http://localhost:8080/api/.

## 📄 Formato del PDF Generado
El motor interno exporta un PDF estructurado con los datos del profesional, el cliente, concepto del servicio, cálculos de retenciones (8%) y montos netos/brutos de manera automática.

## 👨‍💻 Autor
Carlos Arturo Roncal Hermenegildo
* Desarrollador de Software
* [![GitHub](https://img.shields.io/badge/GitHub-ArturoRoncal2704-181717?style=flat&logo=github)](https://github.com/ArturoRoncal2704)
