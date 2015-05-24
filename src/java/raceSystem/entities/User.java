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

    private int userId;
    private String login;
    private int passwordHash;
    private int userType;

    public User() {
    }
    
    public User(int userId, String login, int passwordHash, int userType) {
        this.userId = userId;
        this.login = login;
        this.passwordHash = passwordHash;
        this.userType = userType;
    }
    
    public User(String login, int passwordHash, int userType) {        
        this.login = login;
        this.passwordHash = passwordHash;
        this.userType = userType;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
    
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
}
