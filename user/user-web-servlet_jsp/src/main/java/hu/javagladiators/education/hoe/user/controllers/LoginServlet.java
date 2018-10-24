package hu.javagladiators.education.hoe.user.controllers;

import hu.javagladiators.education.hoe.user.dao.model.User;
import hu.javagladiators.education.hoe.user.service.exceptions.WrongLoginException;
import hu.javagladiators.education.hoe.user.service.model.UserService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author krisztian
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/user/login"})
public class LoginServlet extends HttpServlet{

    @Inject
    UserService service;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramName=req.getParameter("name");
        String paramPassword=req.getParameter("password");
        try{
            User user =service.login(paramName, paramPassword);
            if(user.getRole().equals(UserService.USER_ROLE)){
                getServletContext().getRequestDispatcher("/user/usermenu.jsp").include(req, resp);
            }
            else{
                getServletContext().getRequestDispatcher("/user/adminmenu.jsp").include(req, resp);
            }
        }
        catch(WrongLoginException e){
            getServletContext().getRequestDispatcher("/user/error/login.jsp").include(req, resp);
        }
    }    
}
