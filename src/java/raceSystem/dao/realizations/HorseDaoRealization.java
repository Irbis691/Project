/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.realizations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import raceSystem.dao.interfaces.HorseDao;
import raceSystem.entities.Horse;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class HorseDaoRealization implements HorseDao {

    private final JdbcConnection connection;
    private final static String insertQuery = "INSERT INTO horses (horseName) values (?)";
    private final static String findQuery = "SELECT * FROM horses where horseId = ?";
    private final static String findAllQuery = "SELECT * FROM horses";  
    private final static String findNameQuery = "SELECT horseName FROM horses where horseId = ?";
    private final static String findIdQuery = "SELECT horseId FROM horses where horseName = ?";    
    private final static String updateQuery = "UPDATE horses SET horseName = ? WHERE horseId = ?";
    private final static String deleteQuery = "DELETE FROM horses WHERE horseId = ?";
    

    public HorseDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Horse horse) {
        int id = 0;
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, horse.getHorseName());
                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();
                if (key.next()) {
                    id = key.getInt(1);
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
            Logger.getLogger(HorseDaoRealization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Horse find(int id) {
        Horse horse = new Horse();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findQuery);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    horse.setHorseId(rs.getInt(1));
                    horse.setHorseName(rs.getString(2));
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
            Logger.getLogger(HorseDaoRealization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horse;
    }

    @Override
    public List<Horse> findAll() {
        List<Horse> horses = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findAllQuery);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    horses.add(new Horse(rs.getInt(1), rs.getString(2)));
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
            Logger.getLogger(HorseDaoRealization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horses;
    }              
    
    @Override
    public String findName(int id) {
        String name = null;
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findNameQuery);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    name = rs.getString(1);
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
            Logger.getLogger(HorseDaoRealization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
    @Override
    public int findId(String name) {
        int id = 0;
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findIdQuery);
                statement.setString(1, name);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    id = rs.getInt(1);
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
            Logger.getLogger(HorseDaoRealization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public void update(Horse horse) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updateQuery);
                statement.setString(1, horse.getHorseName());
                statement.setInt(2, horse.getHorseId());
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
            Logger.getLogger(HorseDaoRealization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(deleteQuery);
                statement.setInt(1, id);
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
            Logger.getLogger(HorseDaoRealization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
