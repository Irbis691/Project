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
import raceSystem.dao.interfaces.HorseDao;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class HorseDaoRealization implements HorseDao {

    private final JdbcConnection connection;
    private final static String COLLECTION_NAME = "horses";
    private final static String HORSEID_FIELD = "id";
    private final static String HORSENAME_FIELD = "horseName";

    public HorseDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public String findName(String horseId) {
        String horseName = null;
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject query = new BasicDBObject(HORSEID_FIELD, horseId);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) {
                horseName = cur.next().get(HORSENAME_FIELD).toString();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return horseName;
    }

}
