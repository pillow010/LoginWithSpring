Project Description:

This project is a web application that provides user authentication and management features. It is built using the Spring framework and includes the following functionalities:

1. Login: Users can log in to the application by providing their email and password.
2. Register: New users can create an account by providing their email, password, first name, and last name. The password is securely hashed using the BCryptPasswordEncoder.
3. User List: The application allows administrators to view a list of all registered users. The user list is displayed in a table format, showing the user ID, email, first name, and last name.
4. Logout: Users can securely log out of the application, ending their authenticated session.

The project uses Spring Security for authentication and authorization, ensuring secure access to the application's resources. It also leverages Spring Data JPA for seamless integration with a relational database.

Technologies Used:

- Java
- Spring Framework (Spring Boot, Spring Security, Spring Data JPA)
- Thymeleaf (for server-side rendering of HTML templates)
- Bootstrap (for responsive and modern UI)
- MySQL (or any other supported relational database)

Instructions for Running the Project:

1. Ensure you have Java and Maven installed on your system.
2. Set up a MySQL database and configure the database connection properties in the application.properties file.
3. Clone the project repository from GitHub.
4. Build the project using Maven: `$ mvn clean install`
5. Run the application: `$ mvn spring-boot:run`
6. Open your web browser and access the application at http://localhost:8080.

Feel free to explore the code and customize it according to your needs.

