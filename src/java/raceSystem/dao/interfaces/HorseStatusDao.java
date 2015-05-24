/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.interfaces;

import java.util.List;
import raceSystem.entities.HorseStatus;

/**
 *
 * @author Пазинич
 */
public interface HorseStatusDao {
    
    void insert(HorseStatus user);

    HorseStatus find(int id);

    List<HorseStatus> findAll();
    
    List<HorseStatus> findAll(int raceId);

    void update(HorseStatus horseStatus);
    
    void updatePlace(int id, int place);
    
    void updateCoeff(int id, double coeff);

    void delete(int id);
}
