package servlets;

import dba.*;
import hbn.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

import java.util.List;

public class ChangeStadium extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try{
        String name = request.getParameter("uname");
        String numberofseats = request.getParameter("unumberofseats");
        String datecreate = request.getParameter("udatecreate");
        String city = request.getParameter("ucity");
        if (name.equals("") || numberofseats.equals("")|| datecreate.equals("") || city.equals("")) {
            request.setAttribute("Error", "Заполните все поля");
        } else {
            Stadium stadChange = new Stadium(name, Integer.parseInt(numberofseats), datecreate, city);
            String id = request.getParameter("uid");
            DAStadiums.update(HibernateUtil.getSessionFactory(), Integer.parseInt(id), stadChange);          
            request.setAttribute("ChangeData", stadChange);
        }

        } catch (Exception e) {
            request.setAttribute("Error2", "Не правильно заполненые поля");
        }
        doGet(request, response);
    }

    protected void getRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");    
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/changestadium.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
