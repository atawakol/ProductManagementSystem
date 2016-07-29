## Product Management System

This application performs basic operations to handle the products life cycle.
The Rest Services support the following

- Create a new product
- Get a list of all products
- Get details about a product
- Able to update a product
- Able to set price points for different currencies for a products

### Build and run

#### Configurations
This project is ran by default using the hsqldb. This is in memory DB that enable fast running. Therefore, once the application is closed, the data will disappear 
If you want to use a persistent normal DB,  Open the `application.properties` file and set your own configurations. This application was tested against MYSQL.

#### Prerequisites

- Java 8
- Maven > 3.0

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse 

Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

- Run the application and go on http://localhost:8080/
- 