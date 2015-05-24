/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.entities;

import java.sql.Date;

/**
 *
 * @author Пазинич
 */
public class Race {

    private int raceId;
    private String raceName;
    private Date raceDateTime;

    public Race() {
    }

    public Race(int raceId, String raceName, Date raceDateTime) {
        this.raceId = raceId;
        this.raceName = raceName;
        this.raceDateTime = raceDateTime;
    }
    
    public Race(String raceName, Date raceDateTime) {        
        this.raceName = raceName;
        this.raceDateTime = raceDateTime;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Date getRaceDateTime() {
        return raceDateTime;
    }

    public void setRaceDateTime(Date raceDateTime) {
        this.raceDateTime = raceDateTime;
    }
    
}
