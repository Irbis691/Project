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
        <title>Successful registration page</title>
    </head>
    <body>
    <center>
        <h1>Registration successful</h1>
        <hr>
        <!--<table cellspacing="20" bgcolor = #fc0>-->
        <table>            
            <tbody>
                <tr>
                    <td><a href="index.jsp">Index</a></td>
                    <td><a href="registration.jsp">Registration</a></td>
                    <td><a href="login.jsp">Login</a></td>
                </tr>
            </tbody>
        </table>
        <hr>
        <h3>Welcome, ${user}</h3>
    </center>
</body>
</html>
