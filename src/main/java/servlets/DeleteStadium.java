package servlets;

import dba.*;
import hbn.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

import java.util.List;

public class DeleteStadium extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String stad = request.getParameter("stad");
        DAStadiums.delete(HibernateUtil.getSessionFactory(), Integer.parseInt(stad));

        doGet(request, response);
    }

    protected void getRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModelStadium model = ModelStadium.getInstance();
        List<Stadium> listStadium = model.list();
        request.setAttribute("ListStadiums", listStadium);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/deletestadium.jsp");
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
