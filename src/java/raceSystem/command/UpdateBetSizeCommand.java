/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command;

import javax.servlet.http.HttpServletRequest;
import raceSystem.logic.UpdateBetSizeLogic;
import raceSystem.resource.ConfigurationManager;

/**
 *
 * @author Пазинич
 */
public class UpdateBetSizeCommand implements ActionCommand {

    private static final String PARAM_NAME_BETID = "betId";
    private static final String PARAM_NAME_BETSIZE = "betSize";

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.clientConsole");
        int betId = Integer.parseInt(request.getParameter(PARAM_NAME_BETID));
        double betSize = Double.parseDouble(request.getParameter(PARAM_NAME_BETSIZE));
        UpdateBetSizeLogic.updateBetSize(betId, betSize);
        return page;
    }

}
