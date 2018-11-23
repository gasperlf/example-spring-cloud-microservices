# Example-spring-cloud-microservices
Example to create microservices using spring boot, spring cloud

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java jdk 8

## Model
<img src="https://image.ibb.co/fqREVL/ms-docker-1.png" alt="ms-docker-1" border="0">

## IDE

1. Eclipse
2. Intellij IDEA

# Running 
#### Components
1. Server config
2. Registry-service
3. Gateway-service
4. Customer-service
5. Financial-service
6. Security-service
7. workspace (in this folder you'll find properties files [local, docker[feature]])
8. crete docker image mysql

### Command
 
 ` java -jar [parameters] [name component].jar `

#### Example 

	` java -jar -Dname.property=value example.jar `

Follow the next steps.

1. run Server-config, this will run on port localhost:8888, on  this you need to pass some variables like parameters
    `
    -Dgit.uri=none -Dapi.profiles.mode=native -Dgit.username=none -Dgit.password=none -Dnative.searchLocation=[path folder workpace/profile]
    `
2. Run Registry-servivce this will run on port ***http://localhost:8000*** 

    this is the part where server-config plays, give the properties to Registry-service
    
   ` -Dconfig-server.uri=http://localhost:8888 `
    
    if you did all well in this step put on the browser ***http://localhost:8000*** and will load Eureka's page

3. Run Customer-service this will run on port ***http://localhost:7001*** 
    this is the part where server-config plays, give the properties to Customer-service
    
    ` -Dconfig-server.uri=http://localhost:8888 `
    
4. Run Financial-service this will run on port ***http://localhost:7000*** 
    this is the part where server-config plays, give the properties to Financial-service
    
    ` -Dconfig-server.uri=http://localhost:8888 `
    
5. Run Security-service this will run on port ***http://localhost:7002*** 
    this is the part where server-config plays, give the properties to Security-service
    
    `  -Dconfig-server.uri=http://localhost:8888 `
    
6. Run Gateway-service this will run on port ***http://localhost:8080*** 
    this is the part where server-config plays, give the properties to Gateway-service
       
    ` -Dconfig-server.uri=http://localhost:8888 ` 

7. Creating docker container database - mysql
	
	` docker run --name=mysql1 -d mysql/mysql-server:tag `
	
	Example:
	     - we wil download the image and create container
    
		    ` docker run --name=mysql-docker -p 3306:3306  -e MYSQL_ROOT_PASSWORD=root -d mysql:latest `
		    by default user = root
		
		-We will run de container
		
			` docker run <container id> -it /bin/bash ` 
			 get in de docker container
		
		-We log in in mysql container
			 
			 `mysql -u root -p `
			 
			  after mysql asks for password which is ***root***
			 
		-We will use mysql commnads	
			
			` show databases; `
			
			output
			`
			+--------------------+
			| Database           |
			+--------------------+
			| information_schema |
			| mysql              |
			| performance_schema |
			| sys                |
			+--------------------+ 
			`
		- we create databases according to properties [Security-services and Customer-services]	
		   
		   statement
		   
		   ` CREATE DATABASE customer_service; ` 
		   ` CREATE DATABASE security_service; ` 		   
			
## Contributing

## Versioning

This is the first version.

## Authors

* **Lewis Florez Renza** - *Initial work*

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments