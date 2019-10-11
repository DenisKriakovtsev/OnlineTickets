package servlets;

import dba.DAStadiums;
import hbn.HibernateUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Stadium;
import model.ModelStadium;

public class AddServlet extends HttpServlet {
  public static boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
try{
        String name = request.getParameter("name");
        String numberofseats = request.getParameter("numberofseats");
        String datecreate = request.getParameter("datecreate");
        String city = request.getParameter("city");

        if (isEmpty(name) || isEmpty(numberofseats) || isEmpty(datecreate) || isEmpty(city)) {
            request.setAttribute("Error", "Заполните все поля");
        } else {
            Stadium stadium = new Stadium(name, Integer.parseInt(numberofseats), datecreate, city);
            DAStadiums.insert(HibernateUtil.getSessionFactory(), stadium);
            request.setAttribute("AddStadium", stadium);
        }
        
        } catch (Exception e) {
            request.setAttribute("Error2", "Не правильно заполненые поля");
        }
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(req, resp);
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
