<%-- 
    Document   : successRegPage
    Created on : 18.05.2015, 10:46:57
    Author     : Пазинич
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Successful registration page</title>
    </head>
    <body>
    <div id="wrapper">
        <div id="header"> 
                <h1>Horse Racing</h1>
                <p class="description">Welcome to the best totalizator for horse racing!</p>
                <a href="index.jsp"><img src="logo1.png" alt="horse racing" width="250"></a>
            </div> 
            <ul id="nav">
            <li><a href="index.jsp">Index</a></li>             
            <li><a href="registration.jsp">Registration</a></li>
            <li> <a href="login.jsp">Login</a></li>
            </ul>
        <div id="fullpage">
        <h2>Registration successfully done.</h2>
        <h2>Welcome, ${user}!</h2>
        </div>
    </div>>
</body>
</html>
