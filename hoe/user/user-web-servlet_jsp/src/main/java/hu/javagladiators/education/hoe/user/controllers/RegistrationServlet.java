package hu.javagladiators.education.hoe.user.controllers;

import hu.javagladiators.education.hoe.user.dao.model.User;
import hu.javagladiators.education.hoe.user.service.exceptions.WrongLoginException;
import hu.javagladiators.education.hoe.user.service.exceptions.WrongRegistrationException;
import hu.javagladiators.education.hoe.user.service.model.UserService;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author krisztian
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/user/reg"})
public class RegistrationServlet extends HttpServlet{
    private static final Logger log = Logger.getLogger("RegistrationServlet");

    @Inject
    UserService service;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramName=req.getParameter("name");
        String paramPassword=req.getParameter("password");
        try{
            User user =service.playerRegistration(paramName, paramPassword);
            log.info("--------"+user.getName());
            getServletContext().getRequestDispatcher("/user/usermenu.jsp").include(req, resp);
        }
        catch(WrongRegistrationException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/user/error/registration.jsp").include(req, resp);
        }
    }    
}
