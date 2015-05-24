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
import raceSystem.dao.interfaces.UserDao;
import raceSystem.entities.User;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class UserDaoRealization implements UserDao {

    private final JdbcConnection connection;
    private final static String insertQuery = "INSERT INTO users (login, passwordHash, userType) values (?, ?, ?)";
    private final static String findQuery = "SELECT * FROM users where userId = ?";
    private final static String findAllQuery = "SELECT * FROM users";
    private final static String findLoginsQuery = "SELECT login FROM users";
    private final static String findPassQuery = "SELECT passwordHash FROM users";
    private final static String findTypeQuery = "SELECT userType FROM users where login = ?";
    private final static String findIdQuery = "SELECT userId FROM users where login = ?";
    private final static String updateQuery = "UPDATE users SET login = ?, password = ?, userType = ? WHERE userId = ?";
    private final static String deleteQuery = "DELETE FROM users WHERE login = ?";    

    public UserDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User user) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(insertQuery);
                statement.setString(1, user.getLogin());
                statement.setInt(2, user.getPasswordHash());
                statement.setInt(3, user.getUserType());
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
    public User find(int id) {
        User user = new User();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findQuery);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    user.setUserId(rs.getInt(1));
                    user.setLogin(rs.getString(2));
                    user.setPasswordHash(rs.getInt(3));
                    user.setUserType(rs.getInt(4));
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
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findAllQuery);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    users.add(new User(rs.getInt(1), rs.getString(2),
                            rs.getInt(3), rs.getInt(4)));
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
        return users;
    }
    
    @Override
    public List<String> findLogins() {
        List<String> logins = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findLoginsQuery);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    logins.add(rs.getString(1));
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
        return logins;
    }
    
    @Override
    public List<Integer> findPass() {
        List<Integer> passwords = new ArrayList<>();
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findPassQuery);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    passwords.add(rs.getInt(1));
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
        return passwords;
    }
    
    @Override
    public int getType(String login) {
        int type = 0;
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findTypeQuery);
                statement.setString(1, login);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    type = rs.getInt(1);
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
        return type;
    }
    
    @Override
    public int getId(String login) {
        int id = 0;
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(findIdQuery);
                statement.setString(1, login);
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
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public void update(User user) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(updateQuery);
                statement.setString(1, user.getLogin());
                statement.setInt(2, user.getPasswordHash());
                statement.setInt(3, user.getUserType());
                statement.setInt(4, user.getUserId());
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
    public void delete(String login) {
        Connection con = connection.getConnection();
        PreparedStatement statement = null;
        try {
            try {
                statement = con.prepareStatement(deleteQuery);
                statement.setString(1, login);
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
