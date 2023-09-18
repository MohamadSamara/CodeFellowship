# CodeFellowship

* This application contains the basic authorization login,logout,security and passwordEncoder and save the data in table in dataBase

* you can signup if you don't have username in dataBase

* if you have userName in dataBase you can log in , after login Successfully you will redirect to the home page of the application

* you can see your personal data in profile page

## Features

- User registration and login
- User profiles with personal information and bio
- Secure password storage with encryption
- User authentication and authorization
- Homepage displaying user profiles
- Login and logout functionality

## Getting Started

1. Clone the repository

2. add dependencies : 

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'org.postgresql:postgresql'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
}    
```

3. Configure the application properties: Open `application.properties` and configure your database connection settings.

4. Build the project using Gradle:

   ```
   ./gradlew build
   ```
   
5. Run the application:

   ```
   ./gradlew bootRun
   ```

The application should now be running locally at `http://localhost:8080`.

## Usage

1. Access the application in your web browser:

   ```
   http://localhost:8080
   ```

2. You can sign up for a new account or log in with an existing account.

3. Once logged in, you can view your profile and log out.

