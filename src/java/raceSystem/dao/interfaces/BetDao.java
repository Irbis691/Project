/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.interfaces;

import java.util.List;
import raceSystem.entities.Bet;

/**
 *
 * @author Пазинич
 */
public interface BetDao {

    void insert(Bet user);

    Bet find(int id);

    List<Bet> findAll();
    
    List<Bet> findByUserId(int userId);

    void update(Bet user);
    
    void updateBetSize(int betId, double betSize);

    void delete(int id);
}
