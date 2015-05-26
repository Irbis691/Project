/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.entities;

/**
 *
 * @author Пазинич
 */
public class HorseStatus {

    private String horseStatusId;
    private String horseId;
    private String raceId;

    public HorseStatus() {
    }
    
    public HorseStatus(String horseStatusId, String raceId, String horseId) {
        this.horseStatusId = horseStatusId;
        this.horseId = horseId;
        this.raceId = raceId;
    }

    public String getHorseStatusId() {
        return horseStatusId;
    }

    public void setHorseStatusId(String horseStatusId) {
        this.horseStatusId = horseStatusId;
    }
    
    public String getHorseId() {
        return horseId;
    }

    public void setHorseId(String horseId) {
        this.horseId = horseId;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

}
