/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.interfaces;

import com.mongodb.WriteResult;
import java.util.List;
import raceSystem.entities.User;

/**
 *
 * @author Пазинич
 */
public interface UserDao {

    WriteResult insert(User user);

    List<String> findLogins();

    List<Integer> findPass();

    String getId(String login);

}
