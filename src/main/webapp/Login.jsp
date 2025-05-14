<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
        body 
        {
            background: linear-gradient(135deg,red, yellow, green);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .login-container 
        {
            background: white;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: -5px 5px 5px;
            width: 350px;
            text-align: center;
        }
        .login-container h2 
        {
            margin-bottom: 20px;
            color: red;
        }
        .login-container input[type="tel"],
        .login-container input[type="email"],
        .login-container input[type="password"] 
        {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            border: 2px solid pink;
            border-radius: 5px;
            font-size: 14px;
        }
        .login-container button 
        {
            width: 60%;
            background-color: black;
            color:white;
            padding: 8px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 15px; 
        }
        .login-container button:hover 
        {
            background-color:yellow;
            color: black;
        }
        .error-message {
            color: red;
            font-size: 14px;
            margin-bottom: 15px;
        }
    </style>
    
</head>
<body>
	<div class="login-container">
        <h2>LOGIN PAGE</h2>
        <form action="Login" method="post">
        
        	<% 
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
                <div class="error-message"><%= errorMessage %></div>
            <% 
                }
            %>
            
            <label>Email:</label>
            <input type="email" placeholder="Enter Your Email" name="email" required>
            
            <label>Password:</label>
            <input type="password" placeholder="Enter Your Password" name="password" required> <br>
            
            <button type="submit">Login</button>
            <p>New User <a href="CreateAccount.jsp">Create Account</a> </p>
        </form>
    </div>
</body>
</html>