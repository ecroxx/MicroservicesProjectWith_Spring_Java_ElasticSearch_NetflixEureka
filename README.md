# MicroservicesProjectWith_Spring_Java_ElasticSearch_NetflixEureka
------------------ IBA CASE STUDY-------------------------------------------------------------------
Microservices Project which consist of tech stack by using Spring,Java,ElasticSearch, Netflix Eureka

Project Consists of 4 main components : 

1-) Service Discovery/Registry - Netflix Eureka 
Tech Stack : Java/Spring + ElasticSearch + EurekaServer

When the services/containers are created or spawned, they registers themself to the EurekaServer and the Eureka keeps the track of the instances; if a service is removed, the Eureka removes it from the manager's service registry. 
If other services need to communicate with each other, it contacts a discovery service to get the instance of another service. 

2-) Configuration Server
Tech Stack : Java/Spring + ElasticSearch + Eureka Config Server

Configuration Server aims to set up the Properties file centralized and shared by all Microservices.It is a Microservice and manages all microservices properties files and  those files are versioned controlled.
Moreover any change in the properties will automatically publish to all microservices without restarting the services

3-) Product Search Service 
Tech Stack : Java/Spring + ElasticSearch + Eureka Client
Microservice which has CRUD capalities on ElasticSearch instance/index by obtaining some criterias which are : 
  -Merchant can list products using a paging mechanism
  -Merchant can sort products by price and inventory (DESCENDING)
  -Each product should have a Product Category,Name, Description, Unit Price, Inventory, Payment Options,Delivery Options
  -A product with an Inventory lower than 5 cannot be listed on the platform


4-) Merchant SignUp Service - Java/Spring + ElasticSearch
Tech Stack : Java/Spring + ElasticSearch + Eureka Client
Microservice which has CRUD capalities on ElasticSearch instance/index by obtaining some criterias which are : 
  -Open to anyone who has access to the app
  -Collect Merchant Type, Merchant Name, Owner Name, Address, Phone Number, Email Address, Password

------------FURTHER SERVICES WHICH ARE NOT IMPLEMENTED------------------------------------------------------------------

5-)In memory Cache 
Tech Stack : Redis / Redisson Java Client
One Redis cluster in order to create centeralized and externalized data storage for session/cookies data and user related data(Password etc.)
Second redis cluster for caching elasticSearch result as a object for performance improvements.


6-)SignIn Services
Tech Stack : Java/Spring + ElasticSearch + Eureka Client
Business service for sign in purpose

7-) Authentication/Authorization Services
Tech Stack : Java/Spring Security + SQL Databse(Postgresql/Oracle/MySQL etc)
Security services

8-) FrontEnd -Web Application
Tech Stack : Java/Spring + JSF/Thymeleaf/Vue.js etc
Fronend service for user interraction

-----------------------------------------------------------------------------------------------------------------------------
NOTE:
The Application Should be Dockerized.For undockerized version of app please change configuration setting as follow:

1-) Config server 
Open bootstrap.properties under src/main/resources and change
"spring.cloud.config.server.native.searchLocations:" variable's value as a your centeralize resource path 

2-) Product Listing Service 
- Open bootstrap.properties under src/main/resources and check parameters value below. If you dont change ports value do not make any change.
"spring.cloud.config.uri="
"eureka.client.service-url.defaultZone=" 

- Open application.properties under src/main/resources and change
"spring.data.elasticsearch.cluster-name="
"spring.data.elasticsearch.cluster-nodes=" variable's values. 
For cluster naming you should add cluster name to your local elasticsearch config.yaml file first then you should add in an application.properties file as a enviroment variable.

3-) Service Discovery
- Open bootstrap.properties under src/main/resources and check parameters value below. If you dont change ports value do not make any change.
"eureka.client.service-url.defaultZone=" 

4-) SingUp Service
- Open application.properties under src/main/resources and check parameters value below. If you dont change ports value do not make any change.Be sure about you created cluster in elasticsearch config file !
"server.port="
"spring.cloud.config.uri="
"eureka.client.service-url.defaultZone="
- Open application.yaml under src/main/resources and check parameters. If you do not change ports value do not make any change.

5-)Start Elasticsearch instance

6-)Make query to endpoints in service controllers by using POSTMAN etc.
-------------------------------------------------------------------------------------------------------------------------------
-----------------------SOME POSTMAN REQUEST EXAMPLES---------------------------------------------------------------------------
Example1: Product Listing Service with Pagination(10)

REQUEST : 
POST http://localhost:8080/product/saveAll
	[
	{
	   "name" : "TV",
	   "category" : "Electronic",
	   "description" : "Samsung 55UHD TV",
	   "price" : 5000,
	   "inventory" : 4 ,
	   "paymentOption" : "Direct"  ,
	   "deliveryOption" : "Two-Day Delivery"
	   
	},
	{
	   "name" : "MacbookAir",
	   "category" : "Electronic",
	   "description" : "Apple MacbookAir13",
	   "price" : 15000,
	   "inventory" : 2 ,
	   "paymentOption" : "Direct" ,
	   "deliveryOption" :" One-Week Delivery"
	},
	
	{
	   "name" : "CocaCola",
	   "category" : "Food",
	   "description" : "CocaCola 2.5L",
	   "price" : 10,
	   "inventory" : 2000 ,
	   "paymentOption" : "Direct" ,
	   "deliveryOption" :"One-Week Delivery"
	},
	
	{
	   "name" : "Starbucks Brazil Coffee",
	   "category" : "Food",
	   "description" : "Brazil FrenchPress Coffee",
	   "price" : 50,
	   "inventory" : 200 ,
	   "paymentOption" : "Installments" ,
	   "deliveryOption" :"Two-Week Delivery"
	}
	
	]

RESPONSE: 
Records saved in the db.
--------------------------------------------------
Example2:
REQUEST: 
GET  http://localhost:8080/product/getAllByPrice

RESPONSE : Products with descending order of price

{
    "content": [
        {
            "id": "EfF8sXQB2QIuxYEfua7X",
            "name": "MacbookAir",
            "category": "Electronic",
            "description": "Apple MacbookAir13",
            "price": 15000,
            "inventory": 2,
            "paymentOption": "Direct",
            "deliveryOption": " One-Week Delivery"
        },
        {
            "id": "EPF8sXQB2QIuxYEfua7X",
            "name": "TV",
            "category": "Electronic",
            "description": "Samsung 55UHD TV",
            "price": 5000,
            "inventory": 4,
            "paymentOption": "Direct",
            "deliveryOption": "Two-Day Delivery"
        },
        {
            "id": "E_F8sXQB2QIuxYEfua7X",
            "name": "Starbucks Brazil Coffee",
            "category": "Food",
            "description": "Brazil FrenchPress Coffee",
            "price": 50,
            "inventory": 200,
            "paymentOption": "Installments",
            "deliveryOption": "Two-Week Delivery"
        },
        {
            "id": "EvF8sXQB2QIuxYEfua7X",
            "name": "CocaCola",
            "category": "Food",
            "description": "CocaCola 2.5L",
            "price": 10,
            "inventory": 2000,
            "paymentOption": "Direct",
            "deliveryOption": "One-Week Delivery"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "facets": [],
    "aggregations": null,
    "scrollId": null,
    "maxScore": "NaN",
    "totalElements": 4,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "numberOfElements": 4,
    "last": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "empty": false
}
---------------------------------------
Example3 : 

REQUEST:
GET http://localhost:8080/product/getAllByInventory

RESPONSE: A product with an Inventory lower than 5 cannot be listed on the platform (which is 4 in this case)
[]

---------------------------------------
Example4 : 

REQUEST:
GET http://localhost:8080/product/getAllByInventory

RESPONSE: A product with an Inventory lower than 5 cannot be listed on the platform (which is 4 in this case)
[]

--------------------------------------------
Example 5 :

Add 2 more item to DB(which has 4 item now) to make total count bigger than 5 and get sorted result of inventory.

---First Request:

POST http://localhost:8080/product/saveAll


	[
		{
	   "name" : "Zara Winter Jacket",
	   "category" : "Fashion",
	   "description" : "Winter Man Jacket",
	   "price" : 1000,
	   "inventory" : 40 ,
	   "paymentOption" : "Installments" ,
	   "deliveryOption" :"One-Day Delivery"
	},
	
	{
	   "name" : "Levis Jean",
	   "category" : "Fashion",
	   "description" : "Levis 501 Jean",
	   "price" : 600,
	   "inventory" : 120 ,
	   "paymentOption" : "Installments" ,
	   "deliveryOption" :"Two-Day Delivery"
	}
	
	]


RESPONSE:
Records saved in the db.

---Second Request:
REQUEST:
GET http://localhost:8080/product/getAllByInventory

RESPONSE: (Which is descending sorted accoırding to inventory)
{
    "content": [
        {
            "id": "EvF8sXQB2QIuxYEfua7X",
            "name": "CocaCola",
            "category": "Food",
            "description": "CocaCola 2.5L",
            "price": 10,
            "inventory": 2000,
            "paymentOption": "Direct",
            "deliveryOption": "One-Week Delivery"
        },
        {
            "id": "E_F8sXQB2QIuxYEfua7X",
            "name": "Starbucks Brazil Coffee",
            "category": "Food",
            "description": "Brazil FrenchPress Coffee",
            "price": 50,
            "inventory": 200,
            "paymentOption": "Installments",
            "deliveryOption": "Two-Week Delivery"
        },
        {
            "id": "v_GAsXQB2QIuxYEfcrP4",
            "name": "Levis Jean",
            "category": "Fashion",
            "description": "Levis 501 Jean",
            "price": 600,
            "inventory": 120,
            "paymentOption": "Installments",
            "deliveryOption": "Two-Day Delivery"
        },
        {
            "id": "vvGAsXQB2QIuxYEfcrP4",
            "name": "Zara Winter Jacket",
            "category": "Fashion",
            "description": "Winter Man Jacket",
            "price": 1000,
            "inventory": 40,
            "paymentOption": "Installments",
            "deliveryOption": "One-Day Delivery"
        },
        {
            "id": "EPF8sXQB2QIuxYEfua7X",
            "name": "TV",
            "category": "Electronic",
            "description": "Samsung 55UHD TV",
            "price": 5000,
            "inventory": 4,
            "paymentOption": "Direct",
            "deliveryOption": "Two-Day Delivery"
        },
        {
            "id": "EfF8sXQB2QIuxYEfua7X",
            "name": "MacbookAir",
            "category": "Electronic",
            "description": "Apple MacbookAir13",
            "price": 15000,
            "inventory": 2,
            "paymentOption": "Direct",
            "deliveryOption": " One-Week Delivery"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "facets": [],
    "aggregations": null,
    "scrollId": null,
    "maxScore": "NaN",
    "totalElements": 6,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "numberOfElements": 6,
    "last": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "empty": false
}

------------------------------------------------------------
Document will be revised when new features added. - 09/2020
