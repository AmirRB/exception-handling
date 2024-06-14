# Exception handling Project

This project aims to manage different exceptions in various forms.  A very simple CRUD has been implemented. To see different exceptions, just make a request to the two APIs below.you can use this api and enter a id that doesn't exist to lis of students then you can see the exception.



## API Endpoints

### 1.Get Student by ID

**request**
```bash
curl --location 'localhost:8080/api/students/100'
```
**response**

```json
{
    "timestamp": "2024-06-14T20:07:40.812+00:00",
    "content": "This Entity doesn't exist",
    "status": 400
}
```

### 2.Delete Student by ID

**request**
```bash
curl --location --request DELETE 'localhost:8080/api/students/200'```
**response**

```json
{
    "timestamp": "2024-06-14T20:11:01.998+00:00",
    "message": "Student not found with ID: 2",
    "details": "uri=/api/students/2"
}
```

I place postman collection in project with "" name

