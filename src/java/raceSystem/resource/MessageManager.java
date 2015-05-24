/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.resource;

import java.util.ResourceBundle;

/**
 *
 * @author Пазинич
 */
public class MessageManager {

    private static final ResourceBundle resourceBundle
            = ResourceBundle.getBundle("resources.message");

    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
