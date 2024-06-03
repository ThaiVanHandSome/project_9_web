<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Milk Tea Chain Store Website</h1>
    <h2>Final Project for Web Programming Course</h2>
    <h3>Overview</h3>
    <p>
        This project is the final assignment for the web programming course. The goal is to develop a fully functional website for a milk tea chain store using the following technologies:
    </p>
    <ul>
        <li><strong>Spring Boot</strong>: For backend framework.</li>
        <li><strong>Bootstrap</strong>: For responsive frontend design.</li>
        <li><strong>JSP</strong>: For rendering dynamic web pages.</li>
        <li><strong>JPA</strong>: For ORM (Object-Relational Mapping).</li>
        <li><strong>SQL Server</strong>: For database management.</li>
    </ul>
    <h3>Features</h3>
    <ul>
        <li><strong>User Authentication</strong>: Registration, login, and user session management.</li>
        <li><strong>Product Catalog</strong>: Display of various milk tea products with details.</li>
        <li><strong>Shopping Cart</strong>: Add, remove, and manage items in the cart.</li>
        <li><strong>Order Management</strong>: Place orders and view order history.</li>
        <li><strong>Admin Panel</strong>: Manage products, view orders, and handle user queries.</li>
    </ul>
    <h3>Installation</h3>    
    <h4>Prerequisites</h4>
    <ul>
        <li><strong>JDK 11</strong> or higher</li>
        <li><strong>Maven</strong></li>
        <li><strong>SQL Server</strong></li>
    </ul>
    
    <h4>Steps</h4>
    <ol>
        <li><strong>Clone the repository</strong>:
            <pre><code>git clone https://github.com/PhuongTay1109/spring-milktea-chain-store</pre>
        </li>
        <li><strong>Navigate to the project directory</strong>:
            <pre><code>cd spring-milktea-chain-store</code></pre>
        </li>
        <li><strong>Configure the database</strong>:
            <p>Create a database in SQL Server. Update the <code>application.properties</code> file in the <code>src/main/resources</code> directory with your SQL Server database configuration:</p>
            <pre><code>spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=milktea
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true</code></pre>
        </li>
        <li><strong>Build the project</strong>:
            <pre><code>mvn clean install</code></pre>
        </li>
        <li><strong>Run the application</strong>:
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
    </ol>
    <h3>Usage</h3>
    <ol>
        <li>Open your web browser and navigate to <code>http://localhost:8080</code>.</li>
        <li>Register a new account or log in with existing credentials.</li>
        <li>Browse the product catalog and add items to your shopping cart.</li>
        <li>Proceed to checkout to place an order.</li>
        <li>Use the admin panel to manage products and orders (accessible for admin users only).</li>
    </ol>
    <h3>Project Structure</h3>
    <ul>
        <li><code>src/main/java</code>: Contains the Java source code for the project.</li>
        <li><code>src/main/resources</code>: Contains the configuration files and static resources.</li>
        <li><code>src/main/webapp</code>: Contains the JSP files for the web pages.</li>
        <li><code>pom.xml</code>: Maven configuration file.</li>
    </ul>
</body>
</html>
