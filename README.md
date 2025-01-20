# Appointment app for doctors and patients - API

A backend API for an appointment scheduling system where doctors can be viewed and added, along with their contact and address information.

## Features

- **Doctor Management**: List and create doctors with their details.
- **Address Management**: Each doctor can have an address associated with them.
- **DTOs for API Responses**: The API returns doctor information in a structured format using Data Transfer Objects (DTOs).
  
## Tech Stack

- **Spring Boot**: Backend framework for building the RESTful API.
- **Spring Data JPA**: ORM for database interaction.
- **H2 Database**: In-memory database for quick development and testing.
- **Lombok**: Java library to reduce boilerplate code (e.g., getters, setters).
- **Maven**: Build and dependency management tool.
