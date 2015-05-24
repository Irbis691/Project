<%-- 
    Document   : placeBets
    Created on : 13.05.2015, 11:33:45
    Author     : Пазинич
--%>
<%@page import="raceSystem.entities.Bet"%>
<%@page import="raceSystem.entities.HorseStatus"%>
<%@page import="raceSystem.entities.Race"%>
<%@page import="java.util.ArrayList"%>
<%@page import="raceSystem.dao.factory.RealDaoFactory"%>
<%@page import="raceSystem.dao.factory.DaoFactory"%>
<%@page import="raceSystem.dao.jdbcConnection.JdbcConnection"%>
<%@page import="raceSystem.resource.ConfigurationManager"%>
<%
    final int CLIENT_TYPE = 3;
    if (session.getAttribute("type") == null
            || (Integer) session.getAttribute("type") != CLIENT_TYPE) {
        response.sendRedirect(ConfigurationManager.getProperty("path.page.backToIndex"));
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            JdbcConnection connection = JdbcConnection.getInstance();
            DaoFactory daoFactory = new RealDaoFactory(connection);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Place your bets!</title>
    </head>
    <body>
    <center>
        <h1>Place your bets!</h1>
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
        <table border = "1">
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
                        <input type="submit" value="Choose">
                        </form>
                    </td>                    
                    <form method="POST" action="./Controller" />
                    <input type = "hidden" name = "command" value = "placeBet" />
                    <input type = "hidden" name = "raceName" value = "<%= request.getParameter("race")%>" />
                    <input type = "hidden" name = "userId" value = "<%= session.getAttribute("id")%>" />
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
                    <input type="submit" value="Lose money)">
                    </td>
                    </form>
                </tr>
            </tbody>
        </table>
        <h3>My bets</h3>
        <table border = "1">
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
                                       = (ArrayList<Bet>) daoFactory.createBetDao().findByUserId((Integer)session.getAttribute("id"));
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
        <h3>Update/delete bets</h3>
        <table border = "1">
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
                            Input bet id
                            </br>
                            <input type="text" name="betId">
                            </br>
                            Input new bet size
                            </br>
                            <input type="text" name="betSize">
                            </br></br>
                            <input type="submit" value="Lose money)">
                            </form>
                        </td>
                        <td align = "center">
                            <form method="POST" action="./Controller" />
                            <input type = "hidden" name = "command" value = "deleteBet" />
                            Input bet id
                            </br>
                            <input type="text" name="betId">
                            </br></br>
                            <input type="submit" value="Delete">
                            </form> 
                        </td>
                    </tr>
                </tbody>
        </table>
    </center>
</body>
</html>
