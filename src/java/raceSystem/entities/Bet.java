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
public class Bet {

    private int betId;
    private int userId;
    private int raceId;
    private String horseName;
    private double betSize;

    public Bet() {
    }
    
    public Bet(int betId, int userId, int raceId, String horseName, double betSize) {
        this.betId = betId;
        this.raceId = raceId;
        this.userId = userId;
        this.horseName = horseName;
        this.betSize = betSize;
    }
    
    public Bet(int userId, int raceId, String horseName, double betSize) {        
        this.raceId = raceId;
        this.userId = userId;
        this.horseName = horseName;
        this.betSize = betSize;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public double getBetSize() {
        return betSize;
    }

    public void setBetSize(double betSize) {
        this.betSize = betSize;
    }
    

}
