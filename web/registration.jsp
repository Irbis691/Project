<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Registration page</title>
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
        <h1>Registration page</h1>
        <form method="POST" action="./Controller">
            <input type = "hidden" name = "command" value = "Registration" />
            <input type = "hidden" name = "type" value = "3" />
            <p class="label">Login:</p>
            <input type="text" name="login" />
            <p class="label">Password:</p>
            <input type="password" name="password" />
            <p class="message">${loginNotUniqMessage}</p>
            <p class="message">${wrongAction}</p>
            <p class="message">${nullPage}</p>
            <input type="submit" value="Register" class="button">
        </form>
        </div>
    </div>
</body>
</html>
