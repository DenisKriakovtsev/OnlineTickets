package servlets;
import java.io.IOException; 
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import model.*;

public class ShowMatch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            ModelMatch model = ModelMatch.getInstance();
            List<Matches> matchs = model.list();
            request.setAttribute("ListMatches", matchs);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showmatch.jsp"); 
            requestDispatcher.forward(request, response); 
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
