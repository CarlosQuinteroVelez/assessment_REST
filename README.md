# assessment_REST
REST API 


Paso 1 
Base de datos:
Se una una base de datos en memoria H2
Una vez ejecutado el codigo, desde el jar o desde el ide 
se puede acceder a la administración de la base de datos del programa en el siguiente link
http://localhost:8080/h2-console

![image](https://github.com/CarlosQuinteroVelez/assessment_REST/assets/157841256/7480163e-d9e4-4f2e-873b-470c1a797c21)
User: sa
Pass: password
 una vez authenticado se accede a la consola donde se pueden ejecutar consultas SQL.

usando las siguientes querys se puede comprobar que los datos están siendo guardados correctamente:

SELECT * FROM "USERS";
SELECT * FROM "phones";

una vez ejecutadas las querys se puede ver los usuarios agregados por medio de un POST al servicio
![image](https://github.com/CarlosQuinteroVelez/assessment_REST/assets/157841256/ef1ae118-41c2-4b02-8241-99e7f08aa8da)


EndPoints exxamples:
*************************************************************
POST http://localhost:8080/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "newpassword456",
  "phones": [
    {
      "number": "987654321",
      "citycode": "1",
      "countrycode": "57"
    },
    {
      "number": "123456789",
      "citycode": "1",
      "countrycode": "75"
    }
  ]
}

*************************************************************
GET http://localhost:8080/users/id
*************************************************************
DELETE http://localhost:8080/users/id
*************************************************************


Con 1 como ID
UT http://localhost:8080/users/1
Content-Type: application/json

{
  "name": "John Maxwell",
  "email": "john.maxwell@example.com",
  "password": "updatedpassword123",
  "phones": [
    {
      "id": 1,
      "number": "987654321",
      "citycode": "1",
      "countrycode": "57"
    },
    {
      "id": 2,
      "number": "123456789",
      "citycode": "1",
      "countrycode": "75"
    }
  ]
}
*************************************************************
