<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Index Page</title>
<head>

  <style>
    body {
      margin: 0;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      position: relative;
      overflow: hidden;
      font-family: sans-serif;
    }

    body::before {
      content: "";
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-image: url('https://th.bing.com/th/id/OIP.XtFqzbneWYJZU3wCMItCvgHaE6?w=241&h=180&c=7&r=0&o=5&cb=iwc2&dpr=1.5&pid=1.7');
      background-size: cover;
      background-position: center;
      filter: blur(8px);
      z-index: -1;
    }

    .container {
      background-color: rgba(255, 255, 255, 0.6);
      padding: 40px;
      border-radius: 12px;
      text-align: center;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
      width: 500px;
      height: 200px;
    }

    a {
      text-decoration: none;
      color: blue;
      font-weight: bold;
    }

    a:hover {
      text-decoration: underline;
    }

    .links {
      margin-top: 20px;
      font-size: 18px;
    }
  </style>
  
</head>

<body>

  <div class="container">
  
    <h1 style="text-decoration: underline;text-decoration-color:red;">Welcome to User Portal</h1>
    
    <div class="links">
    
      <div>   New User :- <a href="CreateAccount.jsp">Create Account</a></div> <br>
      
      <div>Existing User :- <a href="Login.jsp">Login</a></div>
      
    </div>
    
  </div>
  
</body>
</html>


