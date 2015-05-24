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

    private int horseStatusId;
    private int horseId;
    private int raceId;
    private int horsePlace;
    private double horseCoeff;

    public HorseStatus() {
    }
    
    public HorseStatus(int horseStatusId, int horseId, int raceId, int horsePlace, double horseCoeff) {
        this.horseStatusId = horseStatusId;
        this.horseId = horseId;
        this.raceId = raceId;
        this.horsePlace = horsePlace;
        this.horseCoeff = horseCoeff;
    }
    
    public HorseStatus(int horseId, int raceId, int horsePlace, double horseCoeff) {        
        this.horseId = horseId;
        this.raceId = raceId;
        this.horsePlace = horsePlace;
        this.horsePlace = horsePlace;
    }

    public int getHorseStatusId() {
        return horseStatusId;
    }

    public void setHorseStatusId(int horseStatusId) {
        this.horseStatusId = horseStatusId;
    }
    
    public int getHorseId() {
        return horseId;
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getHorsePlace() {
        return horsePlace;
    }

    public void setHorsePlace(int horsePlace) {
        this.horsePlace = horsePlace;
    }

    public double getHorseCoeff() {
        return horseCoeff;
    }

    public void setHorseCoeff(double horseCoeff) {
        this.horseCoeff = horseCoeff;
    }

}
