# **Introducing the Simple Food Catalogue API: Your Ultimate Digital Food Management Solution**

## **Introduction**
The Simple Food Catalogue API is a digital platform designed to efficiently manage food items. It offers comprehensive functionalities to add, retrieve, update, and delete food items from your digital catalogue. It also enables CRUD operations, including details such as name, serving size, and nutritional information. Ideal for culinary professionals, health enthusiasts, and foodies, this API facilitates easy maintenance of a detailed food inventory, including nutritional information. Designed with Java and Spring Boot, this project aims to simplify food management for personal or commercial use.

With user-friendliness at its forefront, our API simplifies the management of food data, enabling users to keep a comprehensive list of food items accessible. Embrace the convenience of digital food catalogue management with the Simple Food Catalogue API.

### **Technology Stack**

- **Java**: Core programming language.
- **Spring Boot**: Framework for simplifying the setup and development of new Spring applications.
- **Maven** : Dependency management.
- **JUnit & Mockito**: Testing frameworks for unit testing.
- **JSON**: Data storage format.
- **Swagger**: API documentation.

### **Features**

- **CRUD Operations**: Create, Read, Update, and Delete functionalities for food items.
- **Algorithm Implementation**: Includes an algorithm to calculate total calories of food items based on their nutritional content, and macronutrients.
- **Data Storage**: Utilizes JSON files for persisting food item data.
- **Exception Handling**: Comprehensive error handling for robust API responses.
- **Inheritance**: Demonstrates object-oriented programming (OOP) principles within the API structure through model hierarchy.

## **Getting Started/Installation**
### **Prerequisites**
- Java JDK 17 or newer (https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) 
- Maven for dependency management and project build
- [Git](https://git-scm.com/downloads)
- [Visual Studio Code](https://code.visualstudio.com/Download) or any IDE that supports Java (e.g., IntelliJ IDEA, SpringTool Suite (STS) Eclipse)
   A. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   B. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)


### **Installation Steps**
#### 1. Clone the repository to your local machine:
```sh
git clone [https://github.com/Mariejlo/java-api-assessment]
cd [java-api-assessment]
```
#### 2. Navigate into the project directory:
```sh
cd simple-food-catalogue-api
```

#### 3. Install dependencies using Maven: Open a terminal at the root of the repo directory and run the following command to install the dependencies:

```sh
./mvnw clean dependency: resolve
```

If you are on a Windows machine, that will be:
```cmd
mvnw clean dependency:resolve
```
```sh
mvn install
```

#### 4. Start the Spring Boot application: To start the API in VS Code, press `F5` or tap the 'Play' icon for the `api-assessment` app in the Spring Boot Dashboard.

Alternatively, to start the API from the terminal, run the following command:
```sh
mvn spring-boot:run
```
You should see console output similar to the following (press `Ctrl + C` to exit):

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.1.4:run (default-cli) > test-compile @ api-assessment >>>
[WARNING] The artifact org.hibernate:hibernate-validator:jar:8.0.1.Final has been relocated to org.hibernate.validator:hibernate-validator:jar:8.0.1.Final
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ api-assessment ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 14 source files with javac [debug release 17] to target\classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ api-assessment ---
[INFO] skip non existing resourceDirectory C:\Users\mjlri\cbf\simple-food-catalogue-api\src\test\resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ api-assessment ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 5 source files with javac [debug release 17] to target\test-classes
[INFO] 
[INFO] <<< spring-boot:3.1.4:run (default-cli) < test-compile @ api-assessment <<<
[INFO]
[INFO]
[INFO] --- spring-boot:3.1.4:run (default-cli) @ api-assessment ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)

2024-02-25T13:19:02.216+01:00  INFO 16652 --- [  restartedMain] com.cbfacademy.App                       : Starting App using Java 17.0.8.1 with PID 16652 (C:\Users\mjlri\cbf\simple-food-catalogue-api\target\classes started by mjlri in C:\Users\mjlri\cbf\simple-food-catalogue-api)
## **Initialise your Spring Boot Project** //Remove this part
- **Spring Initializr**: to generate your project skeleton. Choose Java as the language, Maven as the build tool, and add dependencies such as Spring Web and H2 Database for testing purposes.

## **Project Structure**
Organize your project into packages that reflect your API's architecture:
- `*model*`: Contains your domain entities (`*FoodItem.java*`).
- `*repository*`: Interfaces for data access (`*FoodItemRepository.java*`).
- `*service*`: Business logic (`*FoodItemService.java and its implementation*`).
- `*controller*`: API endpoints (`*FoodItemController.java*`).
- `*exception*`: Custom exception handling (`*ResourceNotFoundException.java and GlobalExceptionHandler.java*`).
- `*config*`: Configuration classes (Swagger configuration).
```
## **Implement your Models**
Define your FoodItem class in the model package with annotations for JPA and validation constraints

## **Create Repository Interfaces**
In the `*repository*` package, define interfaces extending `*JPARepository*` for CRUD operations. Use Spring Data JPA to simplify data access.

## **Develop Service Layer**
Implement business logic in your service layer. This includes methods for CRUD operations and any additional logic, such as calorie calculations.

## **Define Controllers**
Create controllers in the controller package. Annotate your class with @RestController and define mappings for each operation (@GetMapping, @PostMapping, etc.).

## **Exception Handling**
Implement exception handling using @ControllerAdvice to manage errors across your API.

## **Data Storage in JSON File**
To store data in a JSON file instead of a traditional database:

- Use Jackson's `*ObjectMapper*` to read and write your model objects from/to a JSON file.
- Modify your repository layer to interact with the JSON file directly. This might involve loading the file on application start, modifying the in-memory list of `*FoodItems*`, and saving it back to the file on changes.

## **Testing**
Write unit tests for your service layer using JUnit and Mockito. Test each method for correctness, especially your calorie calculation logic.



## **Documentation with Swagger**
- **Add Swagger Dependencies**: Include Springfox 3 libraries in your pom.xml.
- **Configure Swagger**: Create a configuration class to enable Swagger UI and customize its settings.
- **Document Your API**: Use Swagger annotations in your controllers to describe endpoints, request bodies, and response models.

## **Run Your Application**
Start your application by running the `main` method in your Spring Boot application class.
Access your endpoints through Swagger UI at *http://localhost:8080/swagger-ui/* or use a tool like Postman.

## **Debugging**
Utilize your IDE's debugging tools to step through your code and identify issues.
Check the console logs for errors and exceptions that can give you hints on what's wrong.

## **Iterate and Improve**
 - Test your API thoroughly.
 - Refine your code based on testing feedback.
 - Continuously improve the API based on new requirements 
### **Usage**
Below are examples of how to use the API:
### **Retrieve All Food Items**
- *GET* `*/api/foodItems*`
   - *Response*: List of all food items in the catalogue.

### **Add a New Food Item**
- *POST* `*/api/foodItems*`
   - *Request Body*: JSON representation of a food item.
   - *Response*: Details of the added food item.

### **Create Food Items, example**
```sh
POST /api/foodItems
Content-Type: application/json

{
  "name": "Apple",
  "servingSize": "100g",
  "caloriesPerServing": 52,
  "fats": 0.2,
  "proteins": 0.3,
  "carbohydrates": 14
}
```

### **Get All Food Items, example**
```sh
GET /api/foodItems

Response: 200 OK
[
  {
    "id": 1,
    "name": "Apple",
    ...
  }
]

```

### **Testing**
To run the unit tests, execute the following command:
```sh
mvn test
```
This is an example of what results you should aim for.
```sh
$ mvn test
[INFO] Scanning for projects...
[INFO]
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The artifact org.hibernate:hibernate-validator:jar:8.0.1.Final has been relocated to org.hibernate.validator:hibernate-validator:jar:8.0.1.Final
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ api-assessment ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 14 source files with javac [debug release 17] to target\classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ api-assessment ---
[INFO] skip non existing resourceDirectory C:\Users\mjlri\cbf\simple-food-catalogue-api\src\test\resources
[INFO]
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ api-assessment ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 5 source files with javac [debug release 17] to target\test-classes
[INFO] 
[INFO] --- surefire:3.0.0:test (default-test) @ api-assessment ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.cbfacademy.apiassessment.FoodItemTest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)


2024-02-25T13:22:08.621+01:00  INFO 34204 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2024-02-25T13:22:08.768+01:00  INFO 34204 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 61728 (http) with context path ''
2024-02-25T13:22:08.785+01:00  INFO 34204 --- [           main] c.cbfacademy.apiassessment.FoodItemTest  : Started FoodItemTest in 4.911 seconds (process running for 6.085)
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
2024-02-25T13:22:09.562+01:00  INFO 34204 --- [o-auto-1-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-02-25T13:22:09.562+01:00  INFO 34204 --- [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-02-25T13:22:09.568+01:00  INFO 34204 --- [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 6 ms
2024-02-25T13:22:09.568+01:00  INFO 34204 --- [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 6 ms
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.195 s - in com.cbfacademy.apiassessment.FoodItemTest
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.754 s
```

### **Error Handling**
The API uses standard HTTP response codes to indicate the success or failure of an API request. For example:

 - *404 Not Found*: The requested resource does not exist.
 - *400 Bad Request*: The request was invalid.

### **Contributing**
Contributions to the Simple Food Catalogue API are welcome! Examples:(documentation improvements, feature requests, bug fixes)

### **License**
This project is licensed under the MIT License - see the LICENSE.md file for details.

### **Contact / Support**
For support or inquiries, feel free to contact [Marie.lopator@gmail.com]

Best of luck!
