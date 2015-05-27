/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command;

import com.mongodb.WriteResult;
import javax.servlet.http.HttpServletRequest;
import raceSystem.logic.PlaceBetLogic;
import raceSystem.resource.ConfigurationManager;
import raceSystem.resource.MessageManager;

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
        String userId = request.getParameter(PARAM_NAME_USERID);
        String raceName = request.getParameter(PARAM_NAME_RACENAME);
        String horseName = request.getParameter(PARAM_NAME_HORSE);
        double betSize = Double.parseDouble(request.getParameter(PARAM_NAME_BETSIZE));
        long betId = System.currentTimeMillis();
        WriteResult result = PlaceBetLogic.palceBet(betId, userId, raceName, horseName, betSize);
        if (result == null) {
            request.setAttribute("errorInsertMessage",
                        MessageManager.getProperty("message.insertError"));
        }
        return page;
    }
    
}
