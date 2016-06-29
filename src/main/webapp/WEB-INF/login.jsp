<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login page</title>
        
        <meta charset="utf-8">
    </head>
    <body>
        <h2>Login</h2>
        
        <% if(request.getParameter("error") != null &&!request.getParameter("error").isEmpty()) { %>
        <p style="color:red;">
            Login failed!
        </p>
        <% } %>
        
        <form action="/login" method="POST">
            <label for="email">Email: </label>
            <input type="text" id="email" name="email" placeholder="email"/>
            <br/>
            
            <label for="password">Password: </label>
            <input type="password" id="password" name="password" placeholder="Password"/>
            <br/>
            
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>