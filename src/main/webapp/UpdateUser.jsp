<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User Page</title>
</head>
<body>
		<div>
			<form action="UpdateUser" method="post">
			<h1>Update Operation</h1>
			
			<input type="text" placeholder="enter your name" name="name" required> <br> <br>
			
			<input type="text" placeholder="enter your address" name="address" required> <br> <br>
			
			<input type="password" placeholder="enter your password" name="password" required> <br> <br>
			
			<input type="submit" value="Update">
			</form>
		</div>
</body>
</html>