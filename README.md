# Custumer Service

### Requisitos

1. JDK 8
1. Maven 3

### Rodando

1. Clone o projeto: `https://github.com/IsaacMelo/tokio-test.git`
1. Entre na pasta `tokio-test` e execute: `mvn spring-boot:run`

# Exemplos de requisições e respostas

REST API para o teste da Tokio Marine

## Obter lista de Clientes

### Requisição

`GET /customers?pageSize=10&pageNo=0&sortBy=name`

### Resposta 

	HTTP/1.1 200
	Content-Type: application/json;charset=UTF-8
	Transfer-Encoding: chunked
	Date: Sun, 27 Oct 2019 23:57:17 GMT

    {
    "content": [
        {
            "id": 2,
            "name": "Joãozinho",
            "email": "joaozinho@email.com",
            "address": []
        },
        {
            "id": 1,
            "name": "Mariazinha",
            "email": "mariazinha@email.com",
            "address": []
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "last": true,
    "totalElements": 2,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "numberOfElements": 2,
    "first": true,
    "empty": false
	}


## Criar um novo Cliente

### Requisição

`POST /customers`

	{
		"name": "Joãozinho",
		"email": "joaozinho@email.com"
	}

### Resposta

    HTTP/1.1 201 Created
    Date: Sun, 27 Oct 2019 23:57:17 GMT
    Status: 201 Created
    Content-Type: application/json
    Location: http://localhost:8080/customers/3
	
	{
    	"id": 3,
    	"name": "Joãozinho",
    	"email": "joaozinho@email.com"
	}



## Obter um cliente específico

### Requisição

`GET /customers/:id`


### Resposta

    HTTP/1.1 200 OK
    Date: Sun, 27 Oct 2019 23:57:17 GMT
    Status: 200 OK
    Content-Type: application/json

    {
    	"id": 2,
    	"name": "Joãozinho",
    	"email": "joaozinho@email.com",
    	"address": []
	 }

## Atualizar um cliente

### Requisição

`PUT /customers/:id`

### Resposta

    HTTP/1.1 200 OK
    Date: Sun, 27 Oct 2019 23:57:17 GMT
    Status: 200 OK
    Content-Type: application/json

	{
		"name": "Joãozinho",
		"email": "joaozinho.new@email.com"
	}

## Delete um cliente

### Requisição

`DELETE /customers/:id`

### Resposta

    HTTP/1.1 204 No Content
    Date: Sun, 27 Oct 2019 23:57:17 GMT
    Status: 204 No Content

## Criar um endereço para um cliente

### Requisição

`POST /customers/:id/addresses`

	{
		"city": "São Paulo",
		"street" : "Rua Bahia",
		"number" : "88"
	}

### Resposta

    HTTP/1.1 201 Created
    Date: Sun, 27 Oct 2019 23:57:17 GMT
    Status: 201 Created
    Content-Type: application/json
    Location: http://localhost:8080/customers/1/addresses/3
	
	{
    	"id": 1,
    	"city": "São Paulo",
    	"street": "Rua Bahia",
    	"number": "88"
	}


