<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
</head>
<body>
    <h2>Login Page</h2>
    <form action="/spring-mvc/login" method="post">
        <p><font color="red">${errorMessage}</font></p> <!-- Display error message -->
        Enter your name: <input type="text" name="name"/><br/> 
        Enter password: <input type="password" name="password"/><br/> 
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
