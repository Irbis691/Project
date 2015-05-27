<%-- 
    Document   : placeBets
    Created on : 13.05.2015, 11:33:45
    Author     : Пазинич
--%>
<%@page import="com.hazelcast.core.HazelcastInstance"%>
<%@page import="java.util.Map"%>
<%@page import="com.hazelcast.core.Hazelcast"%>
<%@page import="raceSystem.entities.Bet"%>
<%@page import="raceSystem.entities.HorseStatus"%>
<%@page import="raceSystem.entities.Race"%>
<%@page import="java.util.ArrayList"%>
<%@page import="raceSystem.dao.factory.RealDaoFactory"%>
<%@page import="raceSystem.dao.factory.DaoFactory"%>
<%@page import="raceSystem.dao.jdbcConnection.JdbcConnection"%>
<%@page import="raceSystem.resource.ConfigurationManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%            
            HazelcastInstance hazelcastInstance = Hazelcast.getHazelcastInstanceByName("hazelcastInstance");
            Map<Integer, String> customers = hazelcastInstance.getMap("customers");
            if (customers.get(1) == null) {
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(ConfigurationManager.
                                getProperty("path.page.index"));
                dispatcher.forward(request, response);
            }
            JdbcConnection connection = JdbcConnection.getInstance();
            DaoFactory daoFactory = new RealDaoFactory(connection);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Place your bets!</title>
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
        <h1>Place your bets!</h1>
        <center>
        <table class="bets">
            <thead>
                <tr>
                    <th>Select race</th>
                    <th>Select horse</th>
                    <th>Input size of your bet</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td align = "center">
                        <form method="POST" action="clientConsole.jsp" />
                        <select name="race">
                            <option selected disabled>Choose race</option>
                            <%
                                ArrayList<Race> races
                                        = (ArrayList<Race>) daoFactory.createRaceDao().findAll();
                                for (Race race : races) {
                            %>
                            <option><%= race.getRaceName()%></option>
                            <%
                                }
                            %>
                        </select>
                        </br></br>
                        <input type="submit" value="Choose" class="small_button"/>
                        </form>
                    </td>                    
                    <form method="POST" action="./Controller" />
                    <input type = "hidden" name = "command" value = "placeBet" />
                    <input type = "hidden" name = "raceName" value = "<%= request.getParameter("race")%>" />
                    <input type = "hidden" name = "userId" value = "<%= customers.get(1)%>" />
                    <td valign="top">
                        <select name="horseName">
                            <option selected disabled>Choose horse</option>
                                <%
                                    ArrayList<HorseStatus> horseStat
                                        = (ArrayList<HorseStatus>) daoFactory.
                                    createHorseStatusDao().findAll(daoFactory.
                                        createRaceDao().findRaceId(request.getParameter("race")));
                                    for (HorseStatus stat : horseStat) {
                                %>
                                <option>
                                    <%= daoFactory.createHorseDao().findName(stat.getHorseId())%>
                                </option>
                                <%
                                    }
                                %>
                        </select>                               
                    </td>
                    <td align = "center">
                        <input type="text" name="betSize">
                        </br></br>
                        <input type="submit" value="Lose money)" class="small_button">
                    </td>
                    </form>
                </tr>
            </tbody>
        </table>
        <br/>
        <p class="message">${errorInsertMessage}</p>
        <br/>                
        <h2>My bets</h2>
        <table class="races">
            <thead>
                <tr>
                    <th>Bet id</th>
                    <th>Race</th>
                    <th>Horse</th>
                    <th>Bet size</th>
                </tr>
                <tbody>
                    <%
                               ArrayList<Bet> bets
                                       = (ArrayList<Bet>) daoFactory.createBetDao().findByUserId(customers.get(1));
                               for (Bet bet : bets) {
                    %>
                    <tr>                      
                        <td><%= bet.getBetId()%></td>
                        <td><%= daoFactory.createRaceDao().findRaceName(bet.getRaceId())%></td>
                        <td><%= bet.getHorseName()%></td>
                        <td><%= bet.getBetSize()%></td>                       
                    </tr>
                    <%
                        }
                    %>
                </tbody>
        </table>
        <h2>Update/delete bets</h2>
        <table class="bets">
            <thead>
                <tr>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <tbody>
                    <tr>
                        <td align = "center">
                            <form method="POST" action="./Controller" />
                            <input type = "hidden" name = "command" value = "updateBetSize" />
                            <p class="small_label">Input bet id</p>                            
                            <input type="text" name="betId"/>                            
                            <p class="small_label">Input new bet size</p>                        
                            <input type="text" name="betSize"/>
                            </br></br>
                            <input type="submit" value="Lose money)" class="small_button">
                            </form>
                        </td>
                        <td align = "center">
                            <form method="POST" action="./Controller" />
                            <input type = "hidden" name = "command" value = "deleteBet" />
                            <p class="small_label">Input bet id</p>
                            </br>
                            <input type="text" name="betId"/>
                            </br></br>
                            <input type="submit" value="Delete" class="small_button"/>
                            </form> 
                        </td>
                    </tr>
                </tbody>
        </table>
        <form method="POST" action="./Controller" />
        <input type = "hidden" name = "command" value = "Logout" />
        <input type="submit" value="Logout" class="small_button"/>
        </form> 
        </center>
        </div>
   </div>
</body>
</html>
