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
import raceSystem.dao.interfaces.BetDao;
import raceSystem.entities.Bet;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class BetDaoRealization implements BetDao {

    private final JdbcConnection connection;
    private final static String COLLECTION_NAME = "bets";
    private final static String BETID_FIELD = "id";
    private final static String USERID_FIELD = "userId";
    private final static String RACEID_FIELD = "raceId";
    private final static String HORSENAME_FIELD = "horseName";
    private final static String BETSIZE_FIELD = "betSize";

    public BetDaoRealization(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Bet bet) {
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject person = new BasicDBObject(BETID_FIELD, bet.getBetId())
                    .append(USERID_FIELD, bet.getUserId())
                    .append(RACEID_FIELD, bet.getRaceId())
                    .append(HORSENAME_FIELD, bet.getHorseName())
                    .append(BETSIZE_FIELD, bet.getBetSize());
            collection.insert(person);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public List<Bet> findAll() {
        List<Bet> bets = new ArrayList<>();
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBCursor cur = collection.find();
            while (cur.hasNext()) {
                bets.add(new Bet(cur.next().get(USERID_FIELD).toString(),
                        cur.curr().get(RACEID_FIELD).toString(),
                        cur.curr().get(HORSENAME_FIELD).toString(),
                        (Double) cur.curr().get(HORSENAME_FIELD)));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return bets;
    }

    @Override
    public List<Bet> findByUserId(String userId) {
        List<Bet> bets = new ArrayList<>();
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject query = new BasicDBObject(USERID_FIELD, userId);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) {
                bets.add(new Bet(Long.parseLong(cur.next().get(BETID_FIELD).toString()), 
                        cur.curr().get(USERID_FIELD).toString(),
                        cur.curr().get(RACEID_FIELD).toString(),
                        cur.curr().get(HORSENAME_FIELD).toString(),
                        (Double) cur.curr().get(BETSIZE_FIELD)));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return bets;
    }

    @Override
    public void updateBetSize(long betId, double betSize) {
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            BasicDBObject updateDocument = new BasicDBObject();
            updateDocument.append("$set", new BasicDBObject().append(BETSIZE_FIELD, betSize));
            BasicDBObject searchQuery = new BasicDBObject().append(BETID_FIELD, betId);
            collection.update(searchQuery, updateDocument);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public void delete(long betId) {
        try {
            DB db = connection.getConnection();
            DBCollection collection = db.getCollection(COLLECTION_NAME);
            DBObject query = new BasicDBObject(BETID_FIELD, betId);
            DBCursor cur = collection.find(query);
            while (cur.hasNext()) {
                DBObject forDelete = cur.next();
                collection.remove(forDelete);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
