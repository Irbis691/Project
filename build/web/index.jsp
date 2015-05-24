<%@page import="raceSystem.entities.Race"%>
<%@page import="java.util.ArrayList"%>
<%@page import="raceSystem.dao.jdbcConnection.JdbcConnection"%>
<%@page import="raceSystem.dao.factory.DaoFactory"%>
<%@page import="raceSystem.dao.factory.RealDaoFactory"%>

<html>
    <head>
        <%
            JdbcConnection connection = JdbcConnection.getInstance();
            DaoFactory daoFactory = new RealDaoFactory(connection);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Welcome!</title>
    </head>
    <body>
    <center>
        <h1>Welcome to best totalizator for horse racings!</h1>
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
        <table border="1">
            <tbody>
                <tr>
                    <th colspan="2">Current races</th>
                </tr>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                </tr>
                <%
                    ArrayList<Race> races =
                            (ArrayList<Race>) daoFactory.createRaceDao().findAll();
                    for (Race race : races) {
                %>
                <tr>
                    <td><%= race.getRaceName()%></td>
                    <td><%= race.getRaceDateTime()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </center>
</body>
</html>
