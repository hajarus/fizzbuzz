## Setup


The FizzBuzz service is developed in JAVA 11 environnement with the Spring Boot framework.
The database is a MONGO DB.



To start the service, run the following commands

```
docker-compose build
docker-compose up
```

It will use the pre-built jar, if you want to recompile the jar, assuming you have the proper JDK 11 run:

```
maven clean install
```

## Usages

POST : /fizzbuzz

Call example : curl http://localhost:8080/fizzbuzz -d '{"int1": 1,"str1": "fizz","int2": 5,"str2": "buzz","limit": 100}' -H 'content-type: application/json'
 
GET : /stats 

Call example : curl http://localhost:8080/stats -d -H 'content-type: application/json'
