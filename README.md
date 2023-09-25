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

1. Access the application:
   - Visit `http://localhost:8080` in your web browser.

2. Login or Signup:
   - Use the `/login` page to log in if you already have an account.
   - Use the `/signup` page to create a new account.

3. Explore Features:
   - After logging in, you can access your profile at `/myProfile`.
   - Follow other users to see their posts in your feed using the `/follow/{id}` endpoint.
   - Add posts to your profile using the `/addPost` endpoint.
   - Explore other users and their posts on the `/users` and `/users/{id}` pages.
   - Logout using the `/logout` link.

## Controllers

### 1. `ApplicationUserController`

#### Endpoints:
- `/login`: Renders the login page.
- `/signup`: Renders the signup page.
- `/logout`: Logs the user out.
- `/`: Renders the homepage.

#### Description:
- Manages user authentication and registration.
- Allows users to log in, sign up, and log out.
- Encrypts and stores user passwords securely.
- Implements a custom `authWithHttpServletRequest` method for programmatic authentication.
- Renders the user's profile page after successful login.

### 2. `FollowController`

#### Endpoints:
- `/follow/{id}`: Handles user following actions.
- `/feed`: Displays the user's feed of posts from followed users.

#### Description:
- Allows users to follow other users.
- Users can follow/unfollow others by interacting with the `/follow/{id}` endpoint.
- Displays posts from followed users on the `/feed` page.

### 3. `PostController`

#### Endpoints:
- `/users/{id}`: Renders a user's profile page and displays their posts.
- `/users`: Lists all users.
- `/addPost`: Adds a new post to the user's profile.

#### Description:
- Manages user profiles and posts.
- Displays a user's profile and their posts on the `/users/{id}` page.
- Lists all users on the `/users` page.
- Allows users to add new posts to their profiles via the `/addPost` endpoint.

