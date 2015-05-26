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

    List<HorseStatus> findAll(String raceId);

}
