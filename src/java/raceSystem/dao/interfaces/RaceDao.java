/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.interfaces;

import java.sql.Date;
import java.util.List;
import raceSystem.entities.Race;

/**
 *
 * @author Пазинич
 */
public interface RaceDao {
    
    void insert(Race user);

    Race find(int id);

    List<Race> findAll();
    
    Date findDate(String raceName);
    
    int findRaceId(String raceName);
    
    String findRaceName(int raceId);

    void update(Race user);

    void delete(String id);
}
