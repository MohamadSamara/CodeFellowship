# CodeFellowship

CodeFellowship is a web application that provides user registration, login, and profile management features. It also allows users to create posts and view other users' profiles. The application is built using Spring Boot and Spring Security for authentication and authorization.

## Features

- User registration with secure password storage using encryption.
- User login and authentication.
- User profiles with personal information and a bio.
- Creation of posts by logged-in users.
- Viewing user profiles and their posts.
- Logout functionality.

## Getting Started

Follow these steps to set up and run the CodeFellowship application:

1. Clone the repository

2. Add the required dependencies to your Gradle build file (build.gradle):

   ```gradle
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

2. Sign up for a new account if you don't have one. Provide your username, password, first name, last name, date of birth, and bio.

3. Log in with your credentials if you already have an account.

4. Once logged in, you can view your profile, create posts, visit users profile, and log out.

## Class Details

### `ApplicationUser` (models/ApplicationUser.java)

- Represents a user of the application.
- Implements the `UserDetails` interface for Spring Security.
- Stores user data such as username, password (encrypted), first name, last name, date of birth, and bio.
- Has a one-to-many relationship with `Post` entities to represent user posts.

### `Post` (models/Post.java)

- Represents a user's post.
- Stores the post body and the user who created it.
- Includes a timestamp for the creation date.

### `PostController` (controller/PostController.java)

- Manages user posts and user profiles.
- Provides endpoints for creating and viewing posts.
- Handles post creation and redirects to the user's profile page.
- Implements security checks to ensure users are logged in.

### `ApplicationUserController` (controller/ApplicationUserController.java)

- Manages user registration, login, and profile viewing.
- Implements security-related functionalities, including password encryption.
- Handles user authentication and redirects to the appropriate pages.
- Provides endpoints for user registration, login, and profile viewing.
