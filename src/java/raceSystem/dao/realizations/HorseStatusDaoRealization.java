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
import java.util.ArrayList;
import java.util.List;
import raceSystem.dao.interfaces.HorseStatusDao;
import raceSystem.entities.HorseStatus;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class HorseStatusDaoRealization implements HorseStatusDao {

    private final JdbcConnection connection;
    private final static String COLLECTION_NAME = "horsestatus";
    private final static String HORSESTATUSID_FIELD = "id";
    private final static String RACEID_FIELD = "raceId";
    private final static String HORSEID_FIELD = "horseId";

    public HorseStatusDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<HorseStatus> findAll(String raceId){
        List<HorseStatus> horseStatuses = new ArrayList<>();
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject query = new BasicDBObject(RACEID_FIELD, raceId);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) {
                horseStatuses.add(new HorseStatus(cur.next().get(HORSESTATUSID_FIELD).toString(),
                cur.curr().get(RACEID_FIELD).toString(), cur.curr().get(HORSEID_FIELD).toString()));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return horseStatuses;
    }
  
}
