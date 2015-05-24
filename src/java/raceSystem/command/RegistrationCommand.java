/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command;

import javax.servlet.http.HttpServletRequest;
import raceSystem.logic.RegistrationLogic;
import raceSystem.resource.ConfigurationManager;
import raceSystem.resource.MessageManager;

/**
 *
 * @author Пазинич
 */
public class RegistrationCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_TYPE = "type";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        int type = Integer.parseInt(request.getParameter(PARAM_NAME_TYPE));
        if (RegistrationLogic.checkLoginUniq(login)) {
            RegistrationLogic.regNewUser(login, pass, type);
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.successRegPage");
        } else {
            request.setAttribute("loginNotUniqMessage",
                    MessageManager.getProperty("message.loginNotUniqMessage"));
            page = ConfigurationManager.getProperty("path.page.registration");
        }
        return page;
    }
}
