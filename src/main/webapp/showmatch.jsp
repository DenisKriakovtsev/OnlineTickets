<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.util.List" %>
<%@ page import= "model.Matches" %>
<%@ page import= "model.Stadium" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Список матчей</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" type="text/css" href="css/style.css"> 
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-black w3-opacity w3-right-align">
            <h1>Онлайн покупка билетов</h1>
        </div>

        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3- w3-card-4">
                    <div class="optionStadium">
                        <button class="w3-btn w3-animate-left w3-indigo w3-round-large" onclick="location.href = './AddMatch'">Добавить матч</button>
                        <button class="w3-btn w3-animate-right w3-red w3-round-large" onclick="location.href = './DeleteMatch'">Удалить матч</button>
                    </div>
                    <h1 style="text-shadow:1px 1px 0 #fff">Матчи</h1>
                </div>
                <%
                    List<Matches> matchs = (List<Matches>) request.getAttribute("ListMatches");
                    int id_stad;
                    if (matchs != null && !matchs.isEmpty()) {

                        out.println("<ul class=\"w3-ul\">");
                        for (Matches match : matchs) {

                            if (request.getParameter("id_stad") != null) {
                                id_stad = (Integer.parseInt(request.getParameter("id_stad").toString()));
                            } else {
                                id_stad = (int) match.getStadium().getId();
                            }

                            if (match.getStadium().getId() == id_stad) {
                                out.println("<li class='w3-animate-left'>");
                                out.println("<h2>" + match.getNamematches() + "</h2>");
                                out.println("<h4> Стадион: " + match.getStadium().getName() + "</h4>");
                                out.println("<h4> Цена: " + match.getPrice() + " грн</h4>");
                               
                                out.println("<h4> Дата проведения матча: " + match.getDate().replace('T', ' ') + "</h4>");

                                out.println("<form method='post' action='BuyTicket'>");
                                out.println("<input type='hidden' name='matchId' value=" + match.getId() + ">");
                                out.println("<input type='submit' class='w3-btn w3-green w3-round-large' value='Купить билет'>");
                                out.println("</form>");
                                out.println("</li>");
                            }
                        }
                        out.println("</ul>");
                    } else {
                        out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                                + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                                + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n"
                                + "   <h5>Матчи не найдены</h5>\n"
                                + "</div>");
                    }
                %>

            </div>
        </div>
        <div class="w3-container w3-black w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href = './ShowStadiums'">Назад</button>              
            <button class="w3-btn w3-round-large" onclick="location.href = '.'">На главную</button>
        </div>
    </body>
</html>