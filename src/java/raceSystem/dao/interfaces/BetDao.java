/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.dao.interfaces;

import com.mongodb.WriteResult;
import java.util.List;
import raceSystem.entities.Bet;

/**
 *
 * @author Пазинич
 */
public interface BetDao {

    WriteResult insert(Bet user);

    List<Bet> findAll();
    
    List<Bet> findByUserId(String userId);

    WriteResult updateBetSize(long betId, double betSize);

    WriteResult delete(long betId);
}
