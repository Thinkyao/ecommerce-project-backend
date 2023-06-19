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

There are 8 tables used in this project in-order to maintain the relationship between **product**, **orders**, **customer**, **address**, and **country**.  

### Tables ER Map



## API Documentation
