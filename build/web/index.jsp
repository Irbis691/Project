<%@page import="raceSystem.resource.ConfigurationManager"%>
<%@page import="com.hazelcast.core.HazelcastInstance"%>
<%@page import="java.util.Map"%>
<%@page import="com.hazelcast.core.Hazelcast"%>
<%@page import="raceSystem.entities.Race"%>
<%@page import="java.util.ArrayList"%>
<%@page import="raceSystem.dao.jdbcConnection.JdbcConnection"%>
<%@page import="raceSystem.dao.factory.DaoFactory"%>
<%@page import="raceSystem.dao.factory.RealDaoFactory"%>

<html>
    <head>
        <%
			HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
            Map<Integer, String> customers = hazelcastInstance.getMap("customers");
            if (customers.get(1) != null) {
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(ConfigurationManager.getProperty("path.page.clientConsole"));
                dispatcher.forward(request, response);
            }
            JdbcConnection connection = JdbcConnection.getInstance();
            DaoFactory daoFactory = new RealDaoFactory(connection);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Horse racing</title>
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
            <div id="sidebar">
                <h2>Latest News</h2>
                <p class="news">
                    The winner of the last race is Lesly!
                    <img src="cute_horse.png" width="200">
                </p>
            </div>
        <div id="content">
            <h2>Current races</h2>
            <center>
        <table class="races">
            <tbody>                
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
        </table></center>>
        </div>
            
         </div>
</body>
</html>
