/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command.client;

import raceSystem.command.ActionCommand;
import raceSystem.command.DeleteBetCommand;
import raceSystem.command.LoginCommand;
import raceSystem.command.PlaceBetCommand;
import raceSystem.command.RegistrationCommand;
import raceSystem.command.UpdateBetSizeCommand;

/**
 *
 * @author Пазинич
 */
public enum CommandEnum {

    LOGIN {
                {
                    this.command = new LoginCommand();
                }
            },
    REGISTRATION {
                {
                    this.command = new RegistrationCommand();
                }
            },   
    PLACEBET {
                {
                    this.command = new PlaceBetCommand();
                }
            },
    UPDATEBETSIZE {
                {
                    this.command = new UpdateBetSizeCommand();
                }
            },
    DELETEBET {
                {
                    this.command = new DeleteBetCommand();
                }
            };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
