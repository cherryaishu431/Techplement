<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User Page</title>
</head>
<body>
	    <div>
			<form action="DeleteUser" method="post">
			<h1>Delete Operation</h1>
			
			<input type="text" placeholder="enter your name" name="name" required> <br> <br>
			
			<input type="password" placeholder="enter your password" name="password" required> <br> <br>
			
			<input type="submit" value="Delete">
			</form>
		</div>
</body>
</html>