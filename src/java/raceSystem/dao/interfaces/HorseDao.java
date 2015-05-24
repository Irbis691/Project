/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.interfaces;

import java.util.List;
import raceSystem.entities.Horse;

/**
 *
 * @author Пазинич
 */
public interface HorseDao {
    
    int insert(Horse user);

    Horse find(int id);

    List<Horse> findAll();
    
    String findName(int id);
    
    int findId(String name);

    void update(Horse user);

    void delete(int id);
}
