/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command;

import com.mongodb.WriteResult;
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

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.registration");
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if (!RegistrationLogic.checkLoginUniq(login)) {
            request.setAttribute("loginNotUniqMessage",
                    MessageManager.getProperty("message.loginNotUniqMessage"));
        } else {
            WriteResult result = RegistrationLogic.regNewUser(System.currentTimeMillis(), login, pass);
            if (result == null) {
                request.setAttribute("errorInsertMessage",
                        MessageManager.getProperty("message.insertError"));
            } else {
                request.setAttribute("user", login);
                page = ConfigurationManager.getProperty("path.page.successRegPage");
            }
        }
        return page;
    }
}
