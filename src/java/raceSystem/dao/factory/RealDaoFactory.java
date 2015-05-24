/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.factory;

import raceSystem.dao.interfaces.BetDao;
import raceSystem.dao.interfaces.HorseDao;
import raceSystem.dao.interfaces.HorseStatusDao;
import raceSystem.dao.interfaces.RaceDao;
import raceSystem.dao.interfaces.UserDao;
import raceSystem.dao.realizations.BetDaoRealization;
import raceSystem.dao.realizations.HorseDaoRealization;
import raceSystem.dao.realizations.HorseStatusDaoRealization;
import raceSystem.dao.realizations.RaceDaoRealization;
import raceSystem.dao.realizations.UserDaoRealization;
import raceSystem.dao.jdbcConnection.JdbcConnection;

/**
 *
 * @author Пазинич
 */
public class RealDaoFactory extends DaoFactory{

    private final JdbcConnection connection;

    public RealDaoFactory(JdbcConnection connection) {
        this.connection = connection;

    }
    
    @Override
    public BetDao createBetDao() {
        return new BetDaoRealization(connection);
    }

    @Override
    public HorseDao createHorseDao() {
        return new HorseDaoRealization(connection);
    }

    @Override
    public HorseStatusDao createHorseStatusDao() {
        return new HorseStatusDaoRealization(connection);
    }

    @Override
    public RaceDao createRaceDao() {
        return new RaceDaoRealization(connection);
    }

    @Override
    public UserDao createUserDao() {
        return new UserDaoRealization(connection);
    }
    
}
