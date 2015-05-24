/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JdbcConnection {

    private JdbcConnection() {
        try {
            connection = createConnection();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static JdbcConnection instance;

    public static JdbcConnection getInstance() {
        if (instance == null) {
            instance = new JdbcConnection();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() {
        try {
            if (!connection.isValid(1)) {
                connection.close();
                connection = createConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",
                "root", "1234");
    }

}
