/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command;

import javax.servlet.http.HttpServletRequest;
import raceSystem.logic.PlaceBetLogic;
import raceSystem.resource.ConfigurationManager;

/**
 *
 * @author Пазинич
 */
public class PlaceBetCommand implements ActionCommand {

    private static final String PARAM_NAME_USERID = "userId";
    private static final String PARAM_NAME_RACENAME = "raceName";
    private static final String PARAM_NAME_HORSE = "horseName";
    private static final String PARAM_NAME_BETSIZE = "betSize";
    
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.clientConsole");
        int userId = Integer.parseInt(request.getParameter(PARAM_NAME_USERID));
        String raceName = (String)request.getParameter(PARAM_NAME_RACENAME);
        String horseName = (String)request.getParameter(PARAM_NAME_HORSE);
        double betSize = Double.parseDouble(request.getParameter(PARAM_NAME_BETSIZE));
        PlaceBetLogic.palceBet(userId, raceName, horseName, betSize);
        return page;
    }
    
}
