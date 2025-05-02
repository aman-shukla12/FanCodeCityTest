#FanCode API Test Automation

This project contains automated API tests for the FanCode backend services. It is built using Java, TestNG, RestAssured, and Lombok, and is managed with Maven.


## Tech Stack

- Java 17
- Maven
- TestNG
- RestAssured
- Lombok

## Setup Instructions

### Prerequisites

- Java JDK 17+
- Maven 3.8+
- IDE (e.g., IntelliJ IDEA with Lombok plugin enabled)

### Installation & Running Tests

1. Clone the repository:

   git clone https://github.com/aman-shukla12/FanCodeCityTest.git
   cd FanCodeApiTests
   
2. Run tests via Maven
   mvn clean test OR mvn test -DsuiteXmlFile=testng.xml
