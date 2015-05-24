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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import raceSystem.dao.interfaces.HorseStatusDao;
import raceSystem.entities.HorseStatus;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class HorseStatusDaoRealization implements HorseStatusDao {

    private final JdbcConnection connection;
    private final static String insertQuery = "INSERT INTO horsestatus (horseId, raceId, horsePlace, horseCoeff) values (?, ?, ?, ?))";
    private final static String findQuery = "SELECT * FROM horsestatus where horseStatusId = ?";
    private final static String findAllQuery = "SELECT * FROM horsestatus";
    private final static String findAllByIdQuery = "SELECT * FROM horsestatus where raceId = ?";    
    private final static String updateQuery = "UPDATE horsestatus SET horseId = ?, raceId = ?, horsePlace = ?, horseCoeff = ? WHERE horseStatusId = ?";
    private final static String updatePlaceQuery = "UPDATE horsestatus SET horsePlace = ? WHERE horseId = ?";
    private final static String updateCoeffQuery = "UPDATE horsestatus SET horseCoeff = ? WHERE horseId = ?";    
    private final static String deleteQuery = "DELETE FROM horsestatus WHERE horseStatusId = ?";

    public HorseStatusDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(HorseStatus horseStatus) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(insertQuery);
                statement.setInt(1, horseStatus.getHorseId());
                statement.setInt(2, horseStatus.getRaceId());
                statement.setInt(3, horseStatus.getHorsePlace());
                statement.setDouble(4, horseStatus.getHorseCoeff());
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
    public HorseStatus find(int id) {
        HorseStatus horseStatus = new HorseStatus();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findQuery);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    horseStatus.setHorseStatusId(rs.getInt(1));
                    horseStatus.setHorseId(rs.getInt(2));
                    horseStatus.setRaceId(rs.getInt(3));
                    horseStatus.setHorsePlace(rs.getInt(4));
                    horseStatus.setHorseCoeff(rs.getDouble(5));
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
        return horseStatus;
    }

    @Override
    public List<HorseStatus> findAll() {
        List<HorseStatus> horseStatuses = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findAllQuery);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    horseStatuses.add(new HorseStatus(rs.getInt(1), rs.getInt(2),
                            rs.getInt(3), rs.getInt(4), rs.getDouble(5)));
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
        return horseStatuses;
    }
    
    @Override
    public List<HorseStatus> findAll(int raceId){
        List<HorseStatus> horseStatuses = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findAllByIdQuery);
                statement.setInt(1, raceId);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    horseStatuses.add(new HorseStatus(rs.getInt(1), rs.getInt(2),
                            rs.getInt(3), rs.getInt(4), rs.getDouble(5)));
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
        return horseStatuses;
    }

    @Override
    public void update(HorseStatus horseStatus) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updateQuery);
                statement.setInt(1, horseStatus.getHorseId());
                statement.setInt(2, horseStatus.getRaceId());
                statement.setInt(3, horseStatus.getHorsePlace());
                statement.setDouble(4, horseStatus.getHorseCoeff());
                statement.setInt(5, horseStatus.getHorseStatusId());
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
    public void updatePlace(int id, int place) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updatePlaceQuery);
                statement.setInt(1, place);
                statement.setInt(2, id);
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
    public void updateCoeff(int id, double coeff) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updateCoeffQuery);
                statement.setDouble(1, coeff);
                statement.setInt(2, id);
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
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
