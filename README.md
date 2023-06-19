# Full Stack E-commerce Website Project - Backend Service

## Introduction

This repo contains the source code of the backend service of the Full Stack E-commerce Website project. This backend service mainly provides below functionalities:
- Enable **Search Product** by Product Category or Product Name
- Enable **Search Order History** by user email
- Enable **Place Order** and **Process Payment** with **Stripe API ** 
- Basic CRUD operations on the 8 DB tables.


Key Components of this backend service includes
- **Spring Boot** 2.7.5 and **Java** 11
- **MySQL** DB serve as RDBMS and **Spring Data JPA** serve as ORM
- **Spring Data Rest** provides CURD APIs on the DB tables
- Validating **JWT** (Json Web Token) with Okta (Okta serving as Identity Provider)
- Protect backend endpoints with **Spring Security** Framework
- **Secure frontend & backend communication** for credit card payment processing by using **Java Keystore** (generating keys and certificates)
- Process credit card information by using **Stripe API**.
- Documenting API by using OpenAPI 3.0


## DB Tables & ER Map

> **Note**
> 
> The DDL files of creating schema, users, and tables could by find under the **/DB** folder

There are 8 tables used in this project in-order to maintain the relationship between **product**, **orders**, **customer**, **address**, and **country**.  


### Tables ER Map
![](/assets/Table_ER_Map.png)

### Tables Schemas

- **orders**

  | Field              | Type          | Null  |  Key  | Default | Extra           |
  | ------------------ | ------------- | ----- | ----- | ------- | --------------- |
  | billing_address_id | bigint        | YES   | UNI   | NULL    |                 |
  | customer_id        | bigint        | YES   | MUL   | NULL    |                 |
  | date_created       | datetime(6)   | YES   |       | NULL    |                 |
  | id                 | bigint        | **NO**| PRI   | NULL    | auto_increment  |
  | last_updated       | bigint        | YES   |       | NULL    |                 |
  | order_tracking_number| varchar(255)| YES   |       | NULL    |                 |
  | status             | varchar(128)  | YES   |       | NULL    |                 |
  | total_price        | decimal(19,2) | YES   |       | NULL    |                 |
  | total_quantity     |    int        | YES   |       | NULL    |                 |

- order_item

  | Field              | Type          | Null | Key | Default | Extra           |
  | ------------------ | ------------- | ----- | ----- | ------- | --------------- |
  | id                 | bigint        | NO   | PRI | NULL    | auto_increment |
  | image_url          | varchar(255)  | YES  |     | NULL    |                 |
  | quantity           | int           | YES  |     | NULL    |                 |
  | unit_price         | decimal(19,2) | YES  |     | NULL    |                 |
  | order_id           | bigint        | YES  | MUL | NULL    |                 |
  | product_id         | bigint        | YES  | MUL | NULL    |                 |

- customer

  | Field      | Type         | Null | Key | Default | Extra          |
  | ---------- | ------------ | ---- | --- | ------- | -------------- |
  | id         | bigint       | NO   | PRI | NULL    | auto_increment|
  | first_name | varchar(255) | YES  |     | NULL    |                |
  | last_name  | varchar(255) | YES  |     | NULL    |                |
  | email      | varchar(255) | YES  |     | NULL    |                |

- country

  | Field              | Type              | Null | Key | Default | Extra          |
  | ------------------ | ----------------- | ---- | --- | ------- | -------------- |
  | id                 | smallint unsigned | NO   | PRI |         |                |
  | code               | varchar(2)        | YES  |     |         |                |
  | name               | varchar(255)      | YES  |     |         |                |
  
- address

  | Field    | Type         | Null | Key | Default | Extra          |
  | -------- | ------------ | ---- | --- | ------- | -------------- |
  | id       | bigint       | NO   | PRI |         | auto_increment|
  | city     | varchar(255) | YES  |     |         |                |
  | country  | varchar(255) | YES  |     |         |                |
  | state    | varchar(255) | YES  |     |         |                |
  | street   | varchar(255) | YES  |     |         |                |
  | zip_code | varchar(255) | YES  |     |         |                |
  
- product

  | Field          | Type            | Null | Key | Default | Extra          |
  | -------------- | --------------- | ---- | --- | ------- | -------------- |
  | id             | bigint          | NO   | PRI |         | auto_increment|
  | sku            | varchar(255)    | YES  |     |         |                |
  | name           | varchar(255)    | YES  |     |         |                |
  | description    | varchar(255)    | YES  |     |         |                |
  | unit_price     | decimal(13,2)   | YES  |     |         |                |
  | image_url      | varchar(255)    | YES  |     |         |                |
  | active         | bit(1)          | YES  |     | b'1'    |                |
  | units_in_stock | int             | YES  |     |         |                |
  | date_created   | datetime(6)     | YES  |     |         |                |
  | last_updated   | datetime(6)     | YES  |     |         |                |
  | category_id    | bigint          | NO   | MUL |         |                |

- product_category

  | Field           | Type         | Null | Key | Default | Extra          |
  | --------------- | ------------ | ---- | --- | ------- | -------------- |
  | id              | bigint       | NO   | PRI |         | auto_increment|
  | category_name   | varchar(255) | YES  |     |         |                |

- state

  | Field       | Type               | Null | Key | Default | Extra          |
  | ----------- | ------------------ | ---- | --- | ------- | -------------- |
  | id          | smallint unsigned  | NO   | PRI |         | auto_increment|
  | name        | varchar(255)       | YES  |     |         |                |
  | country_id  | smallint unsigned  | NO   | MUL |         |                |




## API Documentation

> **Note**
> 
> OpenAPI Description Path: https://localhost:8443/v3/api-docs
> Swagger UI Path: https://localhost:8443/swagger-ui.html

In this project, we are using OpenAPI 3.0 to documenting the Spring Boot based backend Restful API. Below are some screen shots. 




