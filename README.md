# E-Kandra API

E-Kandra API is a Spring Boot application that provides endpoints to manage job offers, users, domains, and categories for an online job search platform.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

- Java JDK 11+
- Maven
- PostgreSQL database

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/E-Kandra.git
   cd E-Kandra

    Configure the database:

    Create a PostgreSQL database and update the application.properties file with your database credentials:

    bash

spring.datasource.url=jdbc:postgresql://localhost:5432/e_kandra_db
spring.datasource.username=your-username
spring.datasource.password=your-password

Build and run the application:

bash

    mvn spring-boot:run

Usage

The application will start on http://localhost:8080.
API Documentation

The API endpoints are documented using Swagger. You can access the Swagger UI by navigating to:

bash

http://localhost:8080/swagger-ui.html

The following tags (tables) are available in the API:

    Offer
    User
    Domain
    Category

For each tag, you can perform CRUD operations using HTTP methods:

    POST (Create)
    GET (Read)
    PUT (Update)
    DELETE (Delete)

Contributing

Contributions are welcome! If you'd like to contribute to this project, follow these steps:

    Fork the repository.
    Create a new branch: git checkout -b feature/my-feature
    Make your changes and commit them: git commit -am 'Add some feature'
    Push your changes to the branch: git push origin feature/my-feature
    Submit a pull request.
