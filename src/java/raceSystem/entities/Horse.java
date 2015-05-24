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
public class Horse {

    private int horseId;
    private String horseName;

    public Horse() {
    }

    public Horse(int horseId, String horseName) {
        this.horseId = horseId;
        this.horseName = horseName;
    }

    public int getHorseId() {
        return horseId;
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

}
