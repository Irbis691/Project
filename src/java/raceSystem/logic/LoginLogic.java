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

/**
 *
 * @author Пазинич
 */
public class LoginLogic {

    public static boolean checkLogin(String enterLogin) {
        JdbcConnection connection = JdbcConnection.getInstance();
        DaoFactory daoFactory = new RealDaoFactory(connection);
        ArrayList<String> loginList = (ArrayList<String>) daoFactory.createUserDao().findLogins();
        daoFactory.createUserDao().findLogins();
        for (String logins : loginList) {
            if (logins.equals(enterLogin)) {
                return true;
            }
        }
        return false;        
    }

    public static boolean checkPass(String enterPass) {
        JdbcConnection connection = JdbcConnection.getInstance();
        DaoFactory daoFactory = new RealDaoFactory(connection);
        ArrayList<Integer> passwords = (ArrayList<Integer>) daoFactory.createUserDao().findPass();
        for (Integer pass : passwords) {
            if (pass == enterPass.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public static String getId(String login) {
        JdbcConnection connection = JdbcConnection.getInstance();
        DaoFactory daoFactory = new RealDaoFactory(connection);
        return daoFactory.createUserDao().getId(login);
    }
}
