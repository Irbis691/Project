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

/**
 *
 * @author Пазинич
 */
public class UpdateBetSizeLogic {

    public static WriteResult updateBetSize(long betId, double betSize) {
        JdbcConnection connection = JdbcConnection.getInstance();
        DaoFactory daoFactory = new RealDaoFactory(connection);
        WriteResult result = daoFactory.createBetDao().updateBetSize(betId, betSize);
        return result;
    }
    
}
