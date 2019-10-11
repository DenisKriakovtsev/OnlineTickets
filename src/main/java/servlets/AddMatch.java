package servlets;

import dba.DAMatch;
import hbn.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class AddMatch extends HttpServlet {

    public static boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String namematch = request.getParameter("namematch");
            String dateBegin = request.getParameter("dateBegin");
            double price = Double.parseDouble(request.getParameter("price"));

            String stad = request.getParameter("stad");

            List<Stadium> listStad = ModelStadium.getInstance().list();
            int codD = listStad.indexOf(new Stadium(stad, 0, "", ""));
            Stadium myStad = listStad.get(codD);

            Matches matches = new Matches(namematch, dateBegin, price, myStad);
            DAMatch.insert(HibernateUtil.getSessionFactory(), matches);

            request.setAttribute("AddMatch", namematch);

            
        } catch (Exception e) {
            request.setAttribute("Error", "Заполните правильно все поля");
        }
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelStadium model = ModelStadium.getInstance();
        List<Stadium> listStad = model.list();
        request.setAttribute("ListStadiums", listStad);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addmatch.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Сервлет для добавения данных о матче";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
