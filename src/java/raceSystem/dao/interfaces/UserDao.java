/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.interfaces;

import java.util.List;
import raceSystem.entities.User;

/**
 *
 * @author Пазинич
 */
public interface UserDao {
    
    void insert(User user);

    User find(int id);

    List<User> findAll();
    
    List<String> findLogins();
    
    List<Integer> findPass();
    
    int getType(String login);
    
    int getId(String login);

    void update(User user);

    void delete(String login);    
}
