package raceSystem.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Пазинич
 */
public class User {

    private long userId;
    private String login;
    private int passwordHash;

    public User() {
    }
    
    public User(long userId, String login, int passwordHash) {
        this.userId = userId;
        this.login = login;
        this.passwordHash = passwordHash;
    }
    
    public User(String login, int passwordHash) {        
        this.login = login;
        this.passwordHash = passwordHash;
    }
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }
    
}
