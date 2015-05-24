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
import raceSystem.dao.interfaces.BetDao;
import raceSystem.entities.Bet;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class BetDaoRealization implements BetDao {

    private final JdbcConnection connection;
    private final static String insertQuery = "INSERT INTO bets (userId, raceId, horseName, betSize) values (?, ?, ?, ?)";
    private final static String findQuery = "SELECT * FROM bets where betId = ?";
    private final static String findAllQuery = "SELECT * FROM bets";
    private final static String findByUserIdQuery = "SELECT * FROM bets where userId = ?";   
    private final static String updateQuery = "UPDATE bets SET userId = ?, raceId = ?, horseName = ?, betSize = ? WHERE betId = ?";
    private final static String updateBetSizeQuery = "UPDATE bets SET betSize = ? WHERE betId = ?";    
    private final static String deleteQuery = "DELETE FROM bets WHERE betId = ?";

    public BetDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Bet bet) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(insertQuery);
                statement.setInt(1, bet.getUserId());
                statement.setInt(2, bet.getRaceId());
                statement.setString(3, bet.getHorseName());
                statement.setDouble(4, bet.getBetSize());
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
    public Bet find(int id) {
        Bet bet = new Bet();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findQuery);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    bet.setBetId(rs.getInt(1));
                    bet.setUserId(rs.getInt(2));
                    bet.setRaceId(rs.getInt(3));
                    bet.setHorseName(rs.getString(4));
                    bet.setBetSize(rs.getDouble(5));
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
        return bet;
    }

    @Override
    public List<Bet> findAll() {
        List<Bet> bets = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findAllQuery);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    bets.add(new Bet(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                            rs.getString(4), rs.getDouble(5)));
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
        return bets;
    }
    
    @Override
    public List<Bet> findByUserId(int userId) {
        List<Bet> bets = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findByUserIdQuery);
                statement.setInt(1, userId);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    bets.add(new Bet(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                            rs.getString(4), rs.getDouble(5)));
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
        return bets;
    }

    @Override
    public void update(Bet bet) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updateQuery);
                statement.setInt(1, bet.getUserId());
                statement.setInt(2, bet.getRaceId());
                statement.setString(3, bet.getHorseName());
                statement.setDouble(4, bet.getBetSize());
                statement.setInt(5, bet.getBetId());
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
    public void updateBetSize(int betId, double betSize) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updateBetSizeQuery);
                statement.setDouble(1, betSize);
                statement.setInt(2, betId);
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
