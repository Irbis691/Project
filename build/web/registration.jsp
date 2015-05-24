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
    <center>
        <h1>Registration page</h1>
        <hr>
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
        <form method="POST" action="./Controller">
            <input type = "hidden" name = "command" value = "Registration" />
            <input type = "hidden" name = "type" value = "3" />
            Login:<br/>
            <input type="text" name="login"/>
            <br/>Password:<br/>
            <input type="text" name="password"/>
            <br/>
            <strong>${loginNotUniqMessage}</strong>
            <br/>
            <strong>${wrongAction}</strong>
            <br/>
            <strong>${nullPage}</strong>
            <br/>
            <input type="submit" value="Register">
        </form>
        <hr>
    </center>
</body>
</html>
