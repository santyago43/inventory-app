# Backend API - Spring Boot

This repository contains the backend code developed in Spring Boot. The backend is responsible for managing database connections, mapping data to Java entities, sending and receiving data in JSON format, and serving as the API for the web page.

## Features

- **Database Connection:** The backend uses JPA (Java Persistence API) to manage connections and operations with the database.
- **Data Mapping:** Database entities are mapped to Java classes using JPA/Hibernate.
- **REST API:** Data is sent and received in JSON format through a RESTful API.
- **Controllers:** Implements controllers that handle HTTP requests and perform the corresponding CRUD operations.
- **Security:** Security configuration to protect sensitive routes and handle authentication.

## Project Structure

The project is organized into the following packages:

- `slv.inventories.controller`: Contains the controllers that handle HTTP requests.
- `slv.inventories.model`: Contains the model classes (entities) that are mapped to the database.
- `slv.inventories.repository`: Contains repository interfaces that extend `JpaRepository` to perform CRUD operations.
- `slv.inventories.service`: Contains service classes that encapsulate business logic and communicate with the repositories.
- `slv.inventories.Exception`: Contains exception classes.

## Prerequisites

- Java 22
- Maven 3.6.0 or higher
- MySQL database (or another database compatible with JPA)
