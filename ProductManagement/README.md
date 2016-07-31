Product Management System
=========================

----

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
If you want to use a persistent normal DB,  Open the `application.properties` file and set your own configurations. Don't forget to enable the creation of DB using `spring.jpa.hibernate.ddl-auto = create-drop`

This application was tested against MYSQL.

#### Prerequisites

- Java 8
- Maven > 3.0

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse 

Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

##### From Browser

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke rest services:

	* Get a list of all products and all of its details (price and tags):
		- `/products/`
	* `/products/[id]/`: Get details about a product by id.
	* `/products/filters/?description=[description]`: retrieve a list of products that match the description criteria.
	* `/products/filters/?name=[name]`: retrieve a list of products that match the name criteria.

    
##### using curl 
Use the following URLS with the curl to invoke the rest services:
 
 * `curl -H "Accept:application/json" http://localhost:8080/products/`: Get a list of all products and all of its details (price and tags).
 * `curl -H "Accept:application/json" http://localhost:8080/products/[id]/`: Get details about a product by id.
 * `curl -H "Accept:application/json" http://localhost:8080/products/filters/?description=[description]`: retrieve a list of products that match the description criteria.
 * `curl -H "Accept:application/json" http://localhost:8080/products/filters/?name=[name]`: retrieve a list of products that match the name criteria.
 * `curl -X POST http://localhost:8080/products/filters/?description=[description]`: retrieve a list of products that match the name criteria.
 * `curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/products/ -d '{"name": "CURL Product", "description": "using CURL desc"}'`: Create new Product with name and description.
 * `curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/products/ -d '{"name": "CURL Product with tags", "description": "using CURL desc", "tagList": [{"tagName": "Plastic"},{"tagName": "White"}],"priceList": [{"price":1250,"currency": "EGP"},{"price":123,"currency": "GBP"}]}'`: Create new Product with name, description, tags and list of price. 
 * `curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/products/ -d "@[File_Name]"`: Create new Product with JSON in the file .
 * `curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/products/[id]/ -d '{"name": "CURL Product Updated name", "description": "using CURL desc"}'`: Update the product with [id] to the JSON object.
  * `curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/products/[id]/prices/ -d '{"price": 1000.10, "currency": "EGP"}'`: Set Price and Currency for Product.
 

----

 
#### Notes 
The structure of the FUll JSON product is as follow

```JSON

	{
	  "name": "Product Name",
	  "description": "Detailed product description",
	   "tagList": [
	       {
	         "tagName": "Plastic"
	        },
	        {
	         "tagName": "While"
	        }
	       
	       ],
	    "priceList": [
	    {
	      "price":1250,
	      "currency": "EGP"
	    },
	    {
	      "price":123,
	      "currency": "GBP"
	    }
	  ]
	       
	}
```


 
 
 
   