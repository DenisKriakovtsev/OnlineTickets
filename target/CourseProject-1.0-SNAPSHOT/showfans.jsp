<%@ page import="model.Fans" %>
<%@ page import="java.util.List" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Список болельщиков</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-black w3-opacity w3-right-align">
            <h1>Онлайн покупка билетов</h1>
        </div>

        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-card-4">
                    <h1>Болельщики</h1>
                </div>
                <%
                    List<Fans> fanses = (List<Fans>) request.getAttribute("ListFans");

                    if (fanses != null && !fanses.isEmpty()) {
                        out.println("<ul class=\"w3-ul\">");
                        for (Fans fan : fanses) {
                            out.println("<li class='w3-animate-left'>");
                            out.println("<h4>ФИО: " + fan.getFio() + ", Матч: " +"<b>" + fan.getMatch().getNamematches()+"</b>" +", Сектор: " + fan.getSector() + 
                                    ", Ряд: " +  fan.getRow() + ", Место: " +fan.getPlace()+ 
                                     ", Стадион:  " +  fan.getMatch().getStadium().getName()+"</h4>");                           
                            out.println("</li>");
                        }
                        out.println("</ul>");

                    } else {
                        out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                                + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                                + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n"
                                + "   <h5>Болельщики не найдены</h5>\n"
                                + "</div>");
                    }
                %>

            </div>
        </div>

        <div class="w3-container w3-black w3-bottom w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href = '.'">На главную</button>
        </div>
    </body>
</html>