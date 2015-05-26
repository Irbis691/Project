/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.factory;

import java.util.logging.Level;
import java.util.logging.Logger;
import raceSystem.dao.interfaces.BetDao;
import raceSystem.dao.interfaces.HorseDao;
import raceSystem.dao.interfaces.HorseStatusDao;
import raceSystem.dao.interfaces.RaceDao;
import raceSystem.dao.interfaces.UserDao;

/**
 *
 * @author Пазинич
 */
public abstract class DaoFactory {

    public abstract BetDao createBetDao();
    
    public abstract HorseDao createHorseDao();

    public abstract HorseStatusDao createHorseStatusDao();

    public abstract RaceDao createRaceDao();

    public abstract UserDao createUserDao();

    public static DaoFactory getInstance() {
        try {
            return (DaoFactory) Class.forName("raceSystem.dao.factore.RealDaoFactory").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
