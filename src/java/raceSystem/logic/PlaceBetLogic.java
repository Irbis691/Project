/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.logic;

import com.mongodb.WriteResult;
import raceSystem.dao.factory.DaoFactory;
import raceSystem.dao.factory.RealDaoFactory;
import raceSystem.dao.jdbcConnection.JdbcConnection;
import raceSystem.entities.Bet;

/**
 *
 * @author Пазинич
 */
public class PlaceBetLogic {

    public static WriteResult palceBet(long betId, String userId, String raceName, String horseName, double betSize) {
        JdbcConnection connection = JdbcConnection.getInstance();
        DaoFactory daoFactory = new RealDaoFactory(connection);
        String raceId = daoFactory.createRaceDao().findRaceId(raceName);
        Bet bet = new Bet(betId, userId, raceId, horseName, betSize);
        WriteResult result = daoFactory.createBetDao().insert(bet);
        return result;
    }
    
}
