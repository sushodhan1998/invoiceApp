BE Assignment

A simple invoice system that allows creating invoices, paying invoices, and processing overdue invoices. The system has following APIs:


Features

- Create invoices with a specified amount and due date.
- Retrieve all invoices with their details.
- Pay a specific invoice and update its status accordingly.
- Process overdue invoices by applying late fees.


Application run on port "http://localhost:8080"

 Run the Application

     Clone the repository:
        git clone -b master https://github.com/sushodhan1998/invoiceApp.git

     Change the directory using below command
        cd invoiceApp
              
     Create JAR file in invoiceApp/target use below command 
        mvn clean install

     MAVEN
         To run app using Maven
              mvn spring-boot:run
         To run unit tests on Domain model,
              mvn test
     DOCKER
        To run app using docker-compose
            To start the container
                docker-compose up --build
            To stop  the container
                docker-compose down

Endpoint Available:

Create new invoices with a specified amount and due date.
Request Type: POST

localhost:8080/invoices

Sample Input Payload: 
{
"amount": 200.00,
"dueDate": "2024-11-26"
}

Validations:
	"amount" must be positive
	“dueDate” cannot be null

	Sample Output Payload:
{
    "id": "3"
}

This endpoint will return the ID for the new Invoice created. With the HTTP status code 201 CREATED.



Process overdue invoices by applying late fees 

	Request Type: GET

localhost:8080/invoices 

Sample Input: N/A

Sample Output:










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

Returns the entire invoice list in the system. With HTTP status code 200 OK

Pay a specific invoice and update its status accordingly using the id.

	Request Type: POST
localhost:8080/invoices/{id}/payments

id-> pass the invoice id in endpoint	

	Sample Input Payload:
localhost:8080/invoices/1/payments

{
    "amount": 200.00
}

	
Validation:
		"amount" Paid amount must be zero or positive

Sample Output Payload:
(If full amount paid for invoice)
PAID Successfully!!

OR

(If Amount paid partially calculation is done, Pending amount is show as part of response )

PENDING Amount is  100.0


HTTP status code is 200 OK

Process overdue invoices by applying late fees by checking overdue days

	Request Type: POST
localhost:8080/invoices/process-overdue

Sample Input payload :
	
{
    "lateFee":100.0,
    "overDueDays":1
}
















Sample Output payload

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



HTTP status code is 200 OK

