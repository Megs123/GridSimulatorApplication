# Getting Started
### Problem statement
Consider an infinite grid of white and black squares. The grid is initially all white and there is a machine in one cell facing right. It will move based on the following rules:

If the machine is in a white square, turn 90° clockwise and move forward 1 unit;
If the machine is in a black square, turn 90° counter-clockwise and move forward 1 unit;
At every move flip the color of the base square.
Design and implement a service that will receive HTTP PUT requests with a number of steps the simulation should run, always starting from the same conditions, and output the resulting grid to a file.


###Assumptions
	* All Grids will be white at every request 
	* pointer will reset from 0 at every request .

### Solution Design 
	* Creating a springboot project as it will be easy and fast to test the rest layeras we dont have to deploy on server and this wil be taken care by springboot interal embedded server.
	*We will need below to run the simulation
		*A Grid class that will have Cells and a GridPOinter
		*GridPointer will have a Direction and its current location
		*Cell will have a Color and location X and Y
		*Direction will be a enum RIGHT, LEFT,DOWN,UP
		*Color will be enum BLACK,WHITE
	* For each step first check the current cell color and change the direction
	* For each step move forward according to direction and change X and Y coordinated and flip the color of 		current cell
	* As all the cells are white initially just keep track of all blackcells  
	* save it in the image file
## SWAGGER
	http://localhost:8080/swagger-ui.html
		
### How to run 

** within eclipse goto boot dashboard and start the application . 
	* call PUT request  http://localhost:8080/grid/simulation/{steps} from insomnia/postman
	*simulation result will be saved in project with name of gridSimulatorPath.png
	
** from command line
	* from root directory to create jar
		mvn clean package spring-boot:repackage
	* to run application
		java -jar GridSimulator-0.0.1-SNAPSHOT.jar		
	*call PUT request  http://localhost:8080/grid/simulation/{steps} from insomnia/postman
	*simulation result will be saved in target with name of gridSimulatorPath.png

### Improvement
	* improve test coverage 
	* test rest layer without starting server 
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

