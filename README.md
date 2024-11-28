# Invoice System

This is a simple invoice management system built using Spring Boot. The application allows users to create invoices, pay invoices, and process overdue invoices.

## Features

- Create invoices with a specified amount and due date.
- Retrieve all invoices with their details.
- Pay a specific invoice and update its status accordingly.
- Process overdue invoices by applying late fees.


## Application runs on port "http://localhost:8080"

## Run the Application

     Clone the repository:
        git clone -b master https://github.com/sushodhan1998/invoiceApp.git
        cd invoiceApp

     Change the directory using below command
        cd --Project Path--\invoiceApp\invoiceApp

     To create JAR file in invoiceApp/target use below command
        mvn clean install

     MAVEN
         To run app using Maven
             1 mvn spring-boot:run
         To run unit tests on Domain model,
               mvn test
     DOCKER
        To run app using docker-compose
            To start the container
                docker-compose up --build
            To stop  the container
                docker-compose down

## APIs

### 1. Create Invoice

- Endpoint: `POST localhost:8080/invoices`
- Request Body:
  {
  "amount": 200.00,
  "dueDate": "2024-11-26"
  }

- Response:
  - Status: `201 Created`
  - Body:
  {
      "id": "1"
  }

### 2. Get All Invoices

- Endpoint: `GET localhost:8080/invoices`
- Response:
  - Status: `200 OK`
  - Body:
  [
      {
          "id": "1",
          "amount": 200.0,
          "paidAmount": 0.0,
          "dueDate": "2024-11-26",
          "status": "VOID"
      },
      {
          "id": "2",
          "amount": 300.0,
          "paidAmount": 0.0,
          "dueDate": "2024-11-28",
          "status": "PENDING"
      },
      {
          "id": "3",
          "amount": 200.0,
          "paidAmount": 200.0,
          "dueDate": "2024-11-26",
          "status": "PAID"
      }
  ]


### 3. Pay Invoice

- Endpoint: `POST localhost:8080/invoices/{id}/payments`
- **Request Body**:
  {
  "amount": 200.00,
  "dueDate": "2024-11-26"
  }

- Response:
    - Body:
    (If full amount paid for invoice)
                     PAID Successfully!!
                            OR
    (If Amount paid partially calculation is done, Pending amount is show as part of response )
                    PENDING Amount is  100.0

  - Status: `200 OK`

### 4. Process Overdue Invoices

- Endpoint: `POST localhost:8080/invoices/process-overdue`
- Request Body:
  {
      "lateFee":100.0,
      "overDueDays":5
  }
- Response:
  - Body:
    [
        {
            "id": "1",
            "amount": 200.0,
            "paidAmount": 0.0,
            "dueDate": "2024-11-26",
            "status": "VOID"
        },
        {
            "id": "2",
            "amount": 300.0,
            "paidAmount": 0.0,
            "dueDate": "2024-11-28",
            "status": "PENDING"
        }
    ]
  - Status: `200 OK`

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Postman tool
- docker desktop to run the container

## Assumptions

- The application uses in-memory data structures for storing invoices, making it easy to extend with a database in the future.
- Validations on input data for creating invoices are minimal and can be enhanced.
