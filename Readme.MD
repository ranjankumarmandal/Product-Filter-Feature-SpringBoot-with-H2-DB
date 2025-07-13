# SpringBoot E-Commerce Application Product Filter Feature

# 📦 Spring Boot Product Filter API

A Spring Boot REST API for managing products with support for:

- ✅ Adding single or multiple products
- 🔍 Filtering products with dynamic query parameters
- 💾 Persisting data using H2 in-memory database
- 🧩 Spring Data JPA with Specification pattern
- ⚙️ Pagination support

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 17+
- Maven

### ▶️ Run the App

mvn spring-boot:run


## API Endpoints

### Add a Single Product: POST /products

### Request Body
<pre>{
  "name": "iPhone 14",
  "category": "Electronics",
  "price": 999.99,
  "inStock": true
} </pre>

### Sample Response

<pre>{
  "id": 1,
  "name": "iPhone 14",
  "category": "Electronics",
  "price": 999.99,
  "inStock": true
} </pre>

### Add Multiple Products: POST /products/batch

### Request Body
<pre>[
  {
    "name": "MacBook Pro",
    "category": "Electronics",
    "price": 2500,
    "inStock": true
  },
  {
    "name": "Office Chair",
    "category": "Furniture",
    "price": 300,
    "inStock": false
  }
] </pre>

### Sample Response: 
<pre>[
  {
    "id": 2,
    "name": "MacBook Pro",
    "category": "Electronics",
    "price": 2500,
    "inStock": true
  },
  {
    "id": 3,
    "name": "Office Chair",
    "category": "Furniture",
    "price": 300,
    "inStock": false
  }
] </pre>

## Filter Products: GET /products

### Query Parameters
- Param: name, category, minPrice, maxPrice, inStock, page, size
- Type: String, String, Double, Double, Boolean, Integer, Integer
- Description: Partial match (case-insensitive), Exact match (case-insensitive), Minimum price, Maximum price, Filter by stock availability, Page number (default: 0), Page size (default: 10)

### Example Request
<pre>GET /products?category=electronics&minPrice=500&inStock=true&page=0&size=5 </pre>

### Sample Response: 
<pre>{
  "content": [
    {
      "id": 1,
      "name": "iPhone 14",
      "category": "Electronics",
      "price": 999.99,
      "inStock": true
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 5
  },
  "totalElements": 1,
  "totalPages": 1,
  "last": true
} </pre>

## H2 Database Console
- Access the H2 database at: http://localhost:8080/h2-console
- Use the following settings:
- JDBC URL: jdbc:h2:mem:testdb
- User: sa
- Password: (leave blank)

## Tech Stack
- Spring Boot 3.x
- Spring Data JPA
- H2 In-Memory Database
- Spring Web
- Lombok (optional)

## License
This project is licensed under the MIT License.

## You have some query?
If you have some query, feel free to connect with me here -- [Ranjan Kumar Mandal](https://www.linkedin.com/in/ranjan-kumar-m-818367158/)
