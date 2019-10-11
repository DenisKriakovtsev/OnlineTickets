package servlets;

import dba.DAStadiums;
import hbn.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Stadium;
import model.ModelStadium;

public class ShowStadiums extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ModelStadium model = ModelStadium.getInstance();
        List<Stadium> stadiums = model.list();
        request.setAttribute("ListStadiums", stadiums);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showstadion.jsp"); 
        requestDispatcher.forward(request, response);
    }

    protected void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String stad = request.getParameter("stadid");
        request.setAttribute("stadid", stad);
        //response.sendRedirect("/ChangeDepartmentServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
