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

    private long betId;
    private String userId;
    private String raceId;
    private String horseName;
    private double betSize;

    public Bet() {
    }
    
    public Bet(long betId, String userId, String raceId, String horseName, double betSize) {
        this.betId = betId;
        this.raceId = raceId;
        this.userId = userId;
        this.horseName = horseName;
        this.betSize = betSize;
    }
    
    public Bet(String userId, String raceId, String horseName, double betSize) {        
        this.raceId = raceId;
        this.userId = userId;
        this.horseName = horseName;
        this.betSize = betSize;
    }

    public long getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
