/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raceSystem.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import raceSystem.logic.LoginLogic;
import raceSystem.resource.ConfigurationManager;
import raceSystem.resource.MessageManager;

/**
 *
 * @author Пазинич
 */
public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final int ADMIN_TYPE = 1;
    private static final int BOOKIE_TYPE = 2;
    private static final int CLIENT_TYPE = 3;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login)) {
            if (LoginLogic.checkPass(pass)) {
                HttpSession session = request.getSession();
                session.setAttribute("id" , LoginLogic.getId(login));
                session.setAttribute("type" , LoginLogic.getType(login));
                switch(LoginLogic.getType(login)) {
                    case ADMIN_TYPE:
                        page = ConfigurationManager.getProperty("path.page.adminConsole");
                        break;
                    case BOOKIE_TYPE:
                        page = ConfigurationManager.getProperty("path.page.bookieConsole");
                        break;
                    case CLIENT_TYPE:
                        page = ConfigurationManager.getProperty("path.page.clientConsole");
                        break;
                    default:
                        request.setAttribute("errorPassMessage",
                                MessageManager.getProperty("message.nullPage"));
                        page = ConfigurationManager.getProperty("path.page.login");
                        break;
                }
            } else {
                request.setAttribute("errorPassMessage",
                        MessageManager.getProperty("message.passError"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } else {
            request.setAttribute("errorLoginMessage",
                    MessageManager.getProperty("message.loginError"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
