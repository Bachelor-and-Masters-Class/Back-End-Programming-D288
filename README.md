# Vacation Booking Backend

**WGU D288 · Back-End Programming**

The server side of an online travel store. Customers pick vacations, add excursions, put them in a cart and check out. There is no frontend here by design; this is the API a frontend would call.

## The data

- **Vacation:** a trip you can book. Each has optional **excursions** (add-on activities).
- **Customer:** linked to a **division** (state or province), which is linked to a **country**.
- **Cart:** belongs to a customer and holds **cart items**. Each item is one vacation, with quantity and party size.
- **Status:** order states are a fixed list (`enum`), not free text.

## How it works

- **Repositories** for every table, exposed as REST endpoints automatically (Spring Data REST).
- **Checkout** saves the order in one transaction. If anything fails halfway, it all rolls back, so no half-saved carts.
- **Checkout returns** a tracking number to show the customer.
- **IDs are visible** in API responses, so the frontend can reference records directly.
- **Sample data** (countries, divisions, vacations, excursions) loads at startup.

## Run it

```
./mvnw spring-boot:run
```

Database settings are in `application.properties`.

## Files

- `entities/`: data model
- `dao/`: repositories
- `services/`: checkout logic
- `controllers/`: checkout endpoint
- `config/`: REST settings
- `bootstrap/`: sample data

**Built with:** Java, Spring Boot, Spring Data JPA and REST, Hibernate, Maven, JUnit
