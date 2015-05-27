/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command;

import com.mongodb.WriteResult;
import javax.servlet.http.HttpServletRequest;
import raceSystem.logic.DeleteBetLogic;
import raceSystem.resource.ConfigurationManager;
import raceSystem.resource.MessageManager;

/**
 *
 * @author Пазинич
 */
public class DeleteBetCommand implements ActionCommand {

    private static final String PARAM_NAME_BETID = "betId";
    
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.clientConsole");
        long betId = Long.parseLong(request.getParameter(PARAM_NAME_BETID));        
        WriteResult result = DeleteBetLogic.deleteBetSize(betId);
        if (result == null) {
            request.setAttribute("errorInsertMessage",
                        MessageManager.getProperty("message.insertError"));
        }
        return page;
    }
    
}
