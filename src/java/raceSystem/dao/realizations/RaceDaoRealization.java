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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import raceSystem.dao.interfaces.RaceDao;
import raceSystem.entities.Race;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class RaceDaoRealization implements RaceDao {

    private final JdbcConnection connection;
    private final static String COLLECTION_NAME = "races";
    private final static String RACEID_FIELD = "id";
    private final static String RACENAME_FIELD = "raceName";
    private final static String RACEDATETIME_FIELD = "raceDateTime";

    public RaceDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public List<Race> findAll() {
        List<Race> races = new ArrayList<>();
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBCursor cur = collection.find();
            while (cur.hasNext()) {
                races.add(new Race(cur.next().get(RACENAME_FIELD).toString(),
                        Date.valueOf(LocalDate.parse(cur.curr().get(RACEDATETIME_FIELD).toString()))));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return races;
    }

    @Override
    public String findRaceId(String raceName) {
        String raceId = null;
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject query = new BasicDBObject(RACENAME_FIELD, raceName);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) {
                raceId = cur.next().get(RACEID_FIELD).toString();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return raceId;
    }

    @Override
    public String findRaceName(String raceId) {
        String raceName = null;
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject query = new BasicDBObject(RACEID_FIELD, raceId);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) {
                raceName = cur.next().get(RACENAME_FIELD).toString();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return raceName;
    }

}
