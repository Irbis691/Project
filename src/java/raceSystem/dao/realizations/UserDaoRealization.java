/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.realizations;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.util.ArrayList;
import java.util.List;
import raceSystem.dao.interfaces.UserDao;
import raceSystem.entities.User;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class UserDaoRealization implements UserDao {

    private final JdbcConnection connection;
    private final static String COLLECTION_NAME = "users";
    private final static String USERID_FIELD = "id";
    private final static String USERLOGIN_FIELD = "login";
    private final static String USERPASSWORDHASH_FIELD = "passwordHash";

    public UserDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public WriteResult insert(User user) {
        WriteResult result = null;
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject person = new BasicDBObject(USERID_FIELD, user.getUserId())
                    .append(USERLOGIN_FIELD, user.getLogin())
                    .append(USERPASSWORDHASH_FIELD, user.getPasswordHash());
            result = collection.insert(person);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<String> findLogins() {
        List<String> logins = new ArrayList<>();
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBCursor cur = collection.find();
            while (cur.hasNext()) {
                logins.add(cur.next().get(USERLOGIN_FIELD).toString());
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return logins;
    }

    @Override
    public List<Integer> findPass() {
        List<Integer> passwords = new ArrayList<>();
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBCursor cur = collection.find();
            while (cur.hasNext()) {
                passwords.add((Integer) cur.next().get(USERPASSWORDHASH_FIELD));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return passwords;
    }

    @Override
    public String getId(String login) {
        String id = null;
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject query = new BasicDBObject(USERLOGIN_FIELD, login);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) {
                id = cur.next().get(USERID_FIELD).toString();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return id;
    }
}
