<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="sign.css">
</head>
<body>

    <form action="forgot" method="post">
    <center>
    <h1>            Instagram  </h1>
    
    <h4>Forgot password</h4>
    
    <pre>

     <input type="text"  type="number" placeholder="username" name="user">

     <input type="password" placeholder="New password" name="pass">
     
     <input type="password" placeholder="Re_Enter password" name="pass">


   <button  class="for" type="submit">Login</button>
           <h3>    _____________OR______________</h3>
   <button class="for" type="button" onclick="document.location='signup.jsp'">Signup</button>
                 
    </pre>


  


    </center>
</form>

</body>
</html>