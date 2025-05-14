<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<style>
        body {
           	background-image:url("https://th.bing.com/th/id/OIP.WIPlVI5L7CP66P4IwBIRBwHaEK?w=311&h=180&c=7&r=0&o=5&cb=iwc2&dpr=1.5&pid=1.7");
            background-repeat: none;
            background-size: cover;
      		background-position: center;
            display: flex;
            justify-content: center;
            align-items: center; 
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .registration-container {
/*             background: white;
 */         padding: 30px 50px;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            width: 400px;
           /*  height: 400px; */
        }
        .registration-container input[type="text"],
        .registration-container input[type="email"],
        .registration-container input[type="password"],
        .registration-container input[type="tel"] {
            width: 80%;
            padding: 7px;
            margin: 5px 0;
            border: 3px solid green;
            border-radius: 5px;
            font-size: 10px;
        }
        .registration-container button {
            width: 70%;
            background-color: red;
            color: white;
            padding-left: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 15px;
            margin-right: 10px;
            height: 30px;
        }
        .registration-container button:hover {
            background-color: yellow;
            color: black;
        }
        .registration-container label {
            /* display: block; */
            margin-top: 5px;
            color:white;
            font-weight: bold;
        }
    </style>
</head>
<body>
	<div class="registration-container">
	
	<form action="Registration" method="post">
	<h2 style="padding-left: 60px;text-decoration: underline; text-decoration-color:red;color: yellow ">Registration Form</h2>
	
	<label>User Name      :</label>
	<input type="text" placeholder="Enter Your Name" name="name" required> <br> 
	
	<label>User Email     :</label>
	<input type="email" placeholder="Enter Your Email" name="email" required> <br> 
	
	<label>Password :</label>
	<input type="password" placeholder="Enter Your Password" name="password" required> <br> 
	
	<label>Contact :</label>
	<input type="tel" placeholder="Enter Your Phone Number" name="phone" pattern="\d{10}" maxlength="10" required> <br> 
	
	<label>Address :</label>
	<input type="text" placeholder="Enter Your Address" name="address" required>  <br> 
	
	<label>Gender :</label>
	<label><input type="radio" name="gender" value="Male">Male</label>
	
	<label><input type="radio" name="gender" value="Female">Female</label> 
	
	<label><input type="radio" name="gender" value="Others">Others</label> <br> 
	
	<button type="submit" style="margin-left: 50px">Create Account</button>
	
	</form>
	</div>
</body>
</html>