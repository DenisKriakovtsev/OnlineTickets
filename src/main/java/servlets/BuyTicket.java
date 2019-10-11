package servlets;

import dba.*;
import hbn.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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

public class BuyTicket extends HttpServlet {

    final static String DATE_FORMAT = "dd/MM/yyyy";

    public static boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {

            int matchId = Integer.parseInt(request.getParameter("matchId"));
            List<Matches> listD = ModelMatch.getInstance().list();
            Matches myDep = null;
            for (Matches m : listD) {
                if (m.getId() == matchId) {
                    myDep = m;
                    break;
                }
            }
            System.out.println(myDep);
            String fio = request.getParameter("FIO");
            String sector = request.getParameter("SECTOR");
            String rowInSector = request.getParameter("RowInSector");
            String place = request.getParameter("PLACE");

            if (isEmpty(fio) || isEmpty(sector) || isEmpty(rowInSector) || isEmpty(place)) {
                request.setAttribute("Error", "Заполните все поля");
            } else {
                int s = Integer.parseInt(sector);
                int r = Integer.parseInt(rowInSector);
                int p = Integer.parseInt(place);
                Fans fans = new Fans(fio, s, r, p, myDep);
                DAFans.insert(HibernateUtil.getSessionFactory(), fans);
                request.setAttribute("AddTicket", fio);
            }

        } catch (Exception e) {
            request.setAttribute("Error2", "Не правильно заполненые поля");
        }
        doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelMatch model = ModelMatch.getInstance();
        List<Matches> matchs = model.list();
        request.setAttribute("ListMatches", matchs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/buyticket.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Сервлет для добавения данных о болельщиках";
    }
}
