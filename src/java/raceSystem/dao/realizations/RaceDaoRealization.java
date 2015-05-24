/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.realizations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import raceSystem.dao.interfaces.RaceDao;
import raceSystem.entities.Race;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class RaceDaoRealization implements RaceDao {
    
    private final JdbcConnection connection;
    private final static String insertQuery = "INSERT INTO races (raceName, raceDateTime) values (?, ?)";
    private final static String findQuery = "SELECT * FROM races where raceId = ?";
    private final static String findAllQuery = "SELECT * FROM races";
    private final static String findDate = "SELECT raceDateTime FROM races where raceName = ?";
    private final static String findRaceIdQuery = "SELECT raceId FROM races where raceName = ?";
    private final static String findRaceNameQuery = "SELECT raceName FROM races where raceId = ?";    
    private final static String updateQuery = "UPDATE races SET raceName = ?, raceDateTime = ? WHERE raceId = ?";
    private final static String deleteQuery = "DELETE FROM races WHERE raceName = ?";

    public RaceDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insert(Race race) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(insertQuery);
                statement.setString(1, race.getRaceName());
                statement.setDate(2, race.getRaceDateTime());
                statement.executeUpdate();
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Race find(int id) {
        Race race = new Race();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findQuery);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    race.setRaceId(rs.getInt(1));
                    race.setRaceName(rs.getString(2));
                    race.setRaceDateTime(rs.getDate(3));
                }
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return race;
    }

    @Override
    public List<Race> findAll() {
        List<Race> races = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findAllQuery);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    races.add(new Race(rs.getInt(1), rs.getString(2), rs.getDate(3)));
                }
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return races;
    }
    
    @Override
    public Date findDate(String name){
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        Date date = null;
        try {
            try {
                statement = con.prepareStatement(findDate);
                statement.setString(1, name);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    date = rs.getDate(1);
                }
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    @Override
    public int findRaceId(String raceName) {
        int raceId = 0;
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findRaceIdQuery);
                statement.setString(1, raceName);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    raceId = rs.getInt(1);
                }
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return raceId;
    }
    
    @Override
    public String findRaceName(int raceId){
        String raceName = null;
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findRaceNameQuery);
                statement.setInt(1, raceId);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    raceName = rs.getString(1);
                }
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return raceName;
    }

    @Override
    public void update(Race race) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updateQuery);
                statement.setString(1, race.getRaceName());
                statement.setDate(2, race.getRaceDateTime());
                statement.setInt(3, race.getRaceId());
                statement.executeUpdate();
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String raceName) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(deleteQuery);
                statement.setString(1, raceName);
                statement.executeUpdate();
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
