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

public class DeleteMatch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String match = request.getParameter("match");
        DAMatch.delete(HibernateUtil.getSessionFactory(), Integer.parseInt(match));

        doGet(request, response);
    }

    protected void getRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModelMatch model = ModelMatch.getInstance();
        List<Matches> listMatches = model.list();
        request.setAttribute("ListMatches", listMatches);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/deletematch.jsp");
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
