<br>

# [Inditex Test](https://github.com/franmastucci/inditex)
#### Price retrieval service in a testing context for the company Inditex.
#### Author: [Francisco Mastucci Silva](https://www.linkedin.com/in/franmastucci/).

<br>

## Justification for Layered Architecture

<b>*In opting for a layered architecture for this microservice, several considerations were taken into account. The decision was made based on the nature of the requirements and the specific characteristics of the project. Here are the key factors influencing this choice:*
</b>
<br>

### Scope and Bounded Context:

The microservice addresses a well-defined and bounded context with acotated requirements. A layered architecture aligns well with the clarity and specificity of the identified scope.
###  Domain Size:

The microservice's domain did not warrant the complexity introduced by a more elaborate architecture, such as hexagonal. The domain was not expansive enough to necessitate the extensive modularization offered by hexagonal architecture.
### Infrastructure Requirements:

Considering the infrastructure demands, the microservice did not pose an intricate set of requirements. The simplicity of a layered architecture accommodated the infrastructure needs without introducing unnecessary complexity.
### Maintainability and Simplicity:

The layered architecture promotes maintainability and simplicity. Given the straightforward nature of the microservice's requirements, a layered approach ensures a clear separation of concerns, making it easier to understand and maintain.
### Advantages of Layered Architecture:

#### Clear Separation of Concerns: 
Each layer has a specific responsibility, facilitating a clear separation of concerns and enhancing modularity.
#### Ease of Maintenance: 
The hierarchical structure simplifies maintenance tasks, making it easier to update, extend, or modify specific layers without affecting others.
#### Scalability: 
Layered architectures are inherently scalable, allowing for the independent scaling of individual layers based on demand.
#### Flexibility: 
The modular design enables flexibility, allowing changes to be made within a layer without impacting the entire system.
#### Testing Simplicity: 
Each layer can be tested independently, enabling more straightforward unit testing and validation of the microservice's functionality.
<br><br> *By adopting a layered architecture, we aim to leverage these advantages to efficiently meet the microservice's requirements while maintaining a balance between simplicity and functionality.*
<br>
<br>

## Layers Overview

<b>Controller Layer:</b>
The controller layer orchestrates the interaction between the client and the system. Controllers provide a clear and secure interface to access the microservice's functionalities.

<b>Service Layer:</b>
The service layer acts as an intermediary interface between controllers and repositories, offering an efficient abstraction of business logic.

<b>Repository Layer:</b>
The repository layer is responsible for data persistence. Here, queries to the database are defined and executed, enabling the storage and retrieval of information. Repositories interact with the service layer to provide and receive data, abstracting specific storage details.

<b>Model Layer:</b>
The model layer defines entities and objects representing the microservice's domain. These classes encapsulate data structure and relationships. Models reflect the system's state and behavior, facilitating consistent data manipulation across layers.

<b>Exception Layer:</b>
The exception layer centralizes the management of exceptional situations in the microservice. Here, domain-specific exceptions are defined, and a global handler is implemented to capture and process errors. The exception layer contributes to the system's robustness and reliability by providing meaningful responses in cases of unexpected failures.

<br>

### API Quickstart

```bash
mvn clean install
mvn spring-boot:run
```
<br>

### Running Integration Tests
#### ⚠ Warning: Docker is required for the execution of integration tests via Testcontainers.

```bash
mvn test
```
<br>


### API Endpoints
| Path                                                        | Type | Description                                                 |
|:------------------------------------------------------------|:-----|:------------------------------------------------------------|
| /prices?product={product_id}&brand={brand_name}&date={date} | GET  | Retrieves prices for a specific product and brand at a given date and time |
#### Invoking the Price service:
```curl
curl --location 'http://localhost:8080/prices?product=35455&brand=ZARA&date=2020-06-16%2021:00:00'
```

<br>


### ER Diagram

![](etc/images/prices_model.png)

<br>

### Technology
* **Platform:** Java 11
* **Project type:** Microservice
* **Spring Boot version:** 2.7.5
  <br><br>
