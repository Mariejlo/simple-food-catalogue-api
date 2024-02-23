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



### **Visual Elements**
(I will include screenshots of GIFTs of API usage, and diagrams illustrating flow/functionalities of API)

### **Testing**
To run the unit tests, execute the following command:
```sh
mvn test
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



1. At least one algorithm
1. Unit test at least one class
1. Store the data in a JSON file 
1. Exception handling 
1. Evidence of inheritance
1. Good use of HTTP Protocols - methods, request and response, have full CRUD operations supported 
1. Documentation

### **Learning Outcomes:**

By the end of this assessment, you should be able to:

1. **Design and Architect APIs**: Get to grips with the nitty-gritty of curating a top-quality API, focusing on data flow and endpoint interactions.
1. **Implement Best Practices**: Showcase your adherence to Java & SpringBoot coding standards, error handling, and optimal project structure.
1. **Code Integration**: Seamlessly combine your creations with the provided skeleton codebase.
1. **Exception Management**: Efficiently handle exceptions, ensuring your API remains sturdy and dependable.

Onward with this assessment, you're set for a deep dive into API development with Java and SpringBoot.

## **Design & Requirements**

### **Design Considerations:**
- **API Flow**: Map out your API's progression, from endpoints to their functionalities.

### **Requirements List:**
- **Core**: Make use of Java and SpringBoot.
- **End Points**: Ensure they are detailed and fully operational.
- **Error Handling**: Your API should handle mishaps gracefully and return informative feedback.

### **Learning Outcomes:**
- Acknowledge the pivotal role of a focused design in APIs.
- See firsthand how a detailed requirements list can pave the way for successful development.

## **Repository Management**

- **Consistent Commits**: Commit often, capturing your progress and thought process.
- **README**: Not just an afterthought. Fill it with the essence of your API, setup instructions, and other salient details.

### **Learning Outcomes:**
- Hone your skills in effective version control.
- Recognise the value of a well-curated repository.

## **Code Quality & Structure**

- **Best Practices**: Stick to Java and SpringBoot best practices and conventions.
- **Modularity**: Your code should be modular, reusable, and easily comprehensible.

#### **Learning Outcomes:**
- Craft clean, efficient, and maintainable code.
- Harness Java and SpringBoot to the fullest.

---

## Getting Started

- [Prerequisites](#prerequisites)

- [Setup](#setup)

### Prerequisites

Before you begin, make sure you have the following installed:

1. [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)

2. [Git](https://git-scm.com/downloads)

3. [Visual Studio Code](https://code.visualstudio.com/Download)
   1. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   2. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

Also make sure you have accounts for the following:

1. [GitHub](https://github.com/signup)

### Setup

#### 1. Clone the Repository

```sh
git clone [REPO_URL]
cd [REPO_NAME]
```

Replace [REPO_URL] with the link to your GitHub repository and [REPO_NAME] with the repository's name.

#### 2. Install Dependencies

Open a terminal at the root of the repo directory and run the following command to install the dependencies:

```sh
./mvnw clean dependency:resolve
```

If you are on a Windows machine, that will be:
```cmd
mvnw clean dependency:resolve
```

You should see console output similar to the following:

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] Deleting /Users/user/Dev/cbfacademy/java-api-assessment/target
...
[truncated output]
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.060 s
[INFO] Finished at: 2023-10-03T16:18:25+01:00
[INFO] ------------------------------------------------------------------------
```

#### 3. Running the Application

To start the API in VS Code, press `F5` or tap the 'Play' icon for the `api-assessment` app in the Spring Boot Dashboard.

Alternatively, to start the API from the terminal, run the following command:

```sh
./mvnw spring-boot:run
```
m
Or on Windows:

```cmd
mvnw spring-boot:run
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
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] Deleting /Users/gary/Dev/cbfacademy/java-api-assessment/target
[INFO] 
[INFO] >>> spring-boot:3.1.4:run (default-cli) > test-compile @ api-assessment >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
...
[truncated output]
...
2023-10-03T17:17:34.413+01:00  INFO 35536 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2023-10-03T17:17:34.751+01:00  INFO 35536 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-10-03T17:17:34.756+01:00  INFO 35536 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-10-03T17:17:34.756+01:00  INFO 35536 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2023-10-03T17:17:34.777+01:00  INFO 35536 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-10-03T17:17:34.778+01:00  INFO 35536 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 364 ms
2023-10-03T17:17:34.898+01:00  INFO 35536 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2023-10-03T17:17:34.907+01:00  INFO 35536 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-03T17:17:34.911+01:00  INFO 35536 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Started App in 0.643 seconds (process running for 0.786)
```

Open your browser and navigate to `http://localhost:8080`.

## **Deliverables**

Ensure that your work is merged to the `main` branch of your GitHub repository by the specified deadline (original or extended). Your solution will assessed based on its state *at that point*; any later commits will **not** be taken into account.

## FAQs

- Q: How can I process JSON in Java?
    
    A: There are a number of open-source packages that you can use to manipulate JSON. We recommend [Gson](https://github.com/google/gson), but you can also investigate alternatives like [json-simple](https://github.com/cliftonlabs/json-simple) or [Jackson](https://github.com/FasterXML/jackson-databind/).

- Q: Can I use another IDE I'm more familiar with instead of VS Code, like IntelliJ or Eclipse?

    A: You can if you wish, but only VS Code is formally supported by CBF Academy staff, so you do so at your own risk.

## Top Tips

- :camera_flash: Commit frequently and use meaningful commit messages. A granular, well-labelled history becomes an increasingly valuable asset over time.
- :cactus: Use feature branches. Build the habit of isolating your changes for specific tasks and merging them into your default branch when complete.
- :vertical_traffic_light: Use consistent naming conventions. Choose easily understandable names and naming patterns for your classes, functions and variables.
- :triangular_ruler: Keep your code tidy. Using the built-in formatting of VS Code or other IDEs makes your code easier to read and mistakes easier to spot.
- :books: Read the docs. Whether via Intellisense in your IDE, or browsing online documentation, build a clear understanding of the libraries your code leverages.
- :calendar: Don't wait until the last minute. Plan your work early and make the most of the time available to complete the assessment and avoid pre-deadline palpitations.
- :sos: Ask. :clap: For. :clap: Help! :clap: Your mentors, instructors and assistants are literally here to support you, so *make use of them* - don't sit and struggle in silence.

Best of luck! Remember, it's not just about the destination; it's the journey. Happy coding! 🚀
