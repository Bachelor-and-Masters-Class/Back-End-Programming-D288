**Overview**

This repository contains my completed submission for the WGU course **D288: Back-End Programming**.

The project implements the **server-side backend for a travel vacation booking platform** using Spring Boot. It models the full commerce domain (customers, vacation packages, optional excursions, shopping carts, and checkout) and exposes it through Spring Data REST endpoints backed by a relational database.

The course focus is backend engineering specifically: entity relationship modeling, repository-driven data access, transactional business logic, and API exposure. There is no front end in this repository by design; the deliverable is the service layer that a client application would consume.

**Scenario**

A travel agency needs a backend capable of supporting an online vacation booking storefront. Customers browse vacation packages, add optional excursions to those packages, place them in a cart, and complete a purchase.

The backend must enforce the relationships between these entities, persist orders reliably, and return a confirmation the storefront can display to the customer.

**Project Objectives**

-Model the vacation booking domain as related JPA entities

-Implement repository interfaces for every persisted entity

-Expose repositories as REST resources through Spring Data REST

-Implement a transactional checkout service that creates and persists an order

-Seed reference and sample data at application startup

-Configure API exposure so that entity identifiers are visible to clients

**Domain Model**

**Vacation and Excursion**
A vacation package represents a bookable trip. Excursions are optional add-on activities associated with a vacation, forming a one-to-many relationship.

**Customer, Country, and Division**
Customer records are tied to a geographic division, which in turn belongs to a country, producing a normalized address hierarchy rather than duplicated location strings.

**Cart and CartItem**
A cart belongs to a customer and holds cart items. Each cart item links a vacation to the cart along with quantity and party size, allowing a single order to contain multiple bookings.

**StatusType**
An enumeration defining the lifecycle states an order can occupy, keeping status values type-safe rather than free-text.

**Technical Implementation**

**Repository Layer**
CustomerRepository, VacationRepository, ExcursionRepository, CartRepository, CartItemRepository, CountryRepository, and DivisionRepository provide Spring Data access to each aggregate.

**Checkout Service**
CheckoutService and CheckoutServiceImpl encapsulate order creation. The implementation is transactional, so a failure partway through checkout rolls back rather than leaving an incomplete cart persisted.

**Purchase and PurchaseResponse**
Purchase carries the inbound order payload; PurchaseResponse returns a tracking confirmation to the client. Separating these from entities keeps the checkout contract independent of the persistence model.

**Controller Layer**
CheckoutController exposes the checkout endpoint and delegates directly to the service layer.

**Configuration**
RestDataConfig customizes Spring Data REST behavior, including exposing entity IDs in API responses so clients can reference records without additional lookups.

**Data Bootstrapping**
BootStrapData seeds countries, divisions, vacations, and excursions at startup, giving the application a usable dataset immediately on launch.

**Technologies**

-Java and Spring Boot

-Spring Data JPA and Spring Data REST

-Hibernate ORM

-Maven build and dependency management

-JUnit for testing

**Skills Demonstrated**

-Backend architecture and layered design

-JPA entity modeling with one-to-many and many-to-one relationships

-Repository pattern implementation

-Transactional service design

-REST API exposure through Spring Data REST

-Enumerated type modeling for domain states

-Application bootstrapping and seed data management

-Maven project configuration

**How to Run**

```
./mvnw spring-boot:run
```

Datasource configuration is defined in the application properties file.

**Repository Contents**

-`src/main/java/entities/`: JPA domain entities

-`src/main/java/dao/`: Spring Data repository interfaces

-`src/main/java/services/`: Checkout business logic and purchase models

-`src/main/java/controllers/`: REST controller for checkout

-`src/main/java/config/`: Spring Data REST configuration

-`src/main/java/bootstrap/`: Startup seed data

-`src/main/resources/application.properties`: Datasource and application configuration
