/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.jdbcConnection;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JdbcConnection {

    private JdbcConnection() {
        connection = createConnection();
    }

    private static JdbcConnection instance;

    public static JdbcConnection getInstance() {
        if (instance == null) {
            instance = new JdbcConnection();
        }
        return instance;
    }

    private DB connection;

    public DB getConnection() {
        return connection;
    }

    private DB createConnection() {
        MongoOptions options = new MongoOptions();
        options.setReadPreference(ReadPreference.secondaryPreferred());
        Mongo mongo = new Mongo(getMongoClients(), options);
        WriteConcern concern = new WriteConcern(2, 5000);
        mongo.setWriteConcern(concern);        
        DB db = mongo.getDB("test");
        return db;
    }

    private static List<ServerAddress> getMongoClients() {
        String url = "localhost:27018,localhost:27019,localhost:27020";
        ArrayList<ServerAddress> addr = new ArrayList<>();
        try {
            for (String s : url.split(",")) {
                addr.add(new ServerAddress(s));
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addr;
    }

}
