/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.logic;

import java.util.ArrayList;
import raceSystem.dao.factory.DaoFactory;
import raceSystem.dao.factory.RealDaoFactory;
import raceSystem.dao.jdbcConnection.JdbcConnection;
import raceSystem.entities.User;

/**
 *
 * @author Пазинич
 */
public class RegistrationLogic {

    public static boolean checkLoginUniq(String enterLogin) {
        JdbcConnection connection = JdbcConnection.getInstance();
        DaoFactory daoFactory = new RealDaoFactory(connection);
        ArrayList<String> loginList = (ArrayList<String>) daoFactory.createUserDao().findLogins();
        for (String login : loginList) {
            if (login.equals(enterLogin)) {
                return false;
            }
        }
        return true;
    }
    
    public static void regNewUser(String enterLogin, String enterPass, int type) {
        JdbcConnection connection = JdbcConnection.getInstance();
        DaoFactory daoFactory = new RealDaoFactory(connection);
        User user = new User(enterLogin, enterPass.hashCode(), type);
        daoFactory.createUserDao().insert(user);
    }
}
