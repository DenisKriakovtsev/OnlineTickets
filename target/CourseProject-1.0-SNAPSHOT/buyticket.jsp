<%@page import="model.Matches"%>
<%@page import="java.util.List"%>
<%@page import="model.Fans"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Онлайн билет</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" type="text/css" href="css/style.css"> 	
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-black w3-opacity w3-right-align">
            <h1>Покупка билета</h1>
        </div>

        <div class="w3-container w3-padding">
            <%
                if (request.getAttribute("AddTicket") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                            + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                            + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n"
                            + "   <h5>Приобретен билет: '" + request.getAttribute("AddTicket") + "!</h5>\n"
                            + "</div>");
                }

                if (request.getAttribute("Error") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                            + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                            + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n"
                            + "   <h5>" + request.getAttribute("Error") + "!</h5>\n"
                            + "</div>");
                }
                 if (request.getAttribute("Error2") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                            + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                            + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n"
                            + "   <h5>" + request.getAttribute("Error2") + "!</h5>\n"
                            + "</div>");
                }
            %>            


            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>Купить билет</h2>
                </div>
                <%
                    String matchId = request.getParameter("matchId");
                    List<Matches> matchs = (List<Matches>) request.getAttribute("ListMatches");
                    for (Matches match : matchs) {
                        if (match.getId() == Integer.parseInt(matchId)) {
                            out.println("<h4 class='w3-blue w3-padding w3-center' style='text-shadow:1px 1px 0 #444'>Куда: " + match.getNamematches()
                                    + " | Когда: " +  match.getDate().replace('T', ' ') + "| Где: " + match.getStadium().getName()
                                    + ", г. " + match.getStadium().getCity() + "</h4>");
                        }
                    }
                %> 
                <form method="post" class="w3-selection w3-light-grey w3-padding stadiumBuyTicket">  
                    <label>Фамилия Имя Отчество
                        <input type="text" name="FIO" class="w3-input w3-animate-input w3-border w3-round-large"><br />
                    </label>
                    <label>Сектор
                        <input type="text" name="SECTOR" class="w3-input w3-animate-input w3-border w3-round-large"><br />
                    </label>
                    <label>Ряд
                        <input type="text" name="RowInSector" class="w3-input w3-animate-input w3-border w3-round-large"><br />
                    </label>
                    <label>Место
                        <input type="text" name="PLACE" class="w3-input w3-animate-input w3-border w3-round-large"><br />
                    </label>
                    <input type="hidden" value="<%=matchId%>" name="matchId">
                    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom" style="width: 30%;text-shadow:1px 1px 0 #444;">Купить</button>
                </form> 
            </div>
        </div>

        <div class="w3-container w3-black w3-bottom w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href = './ShowMatch'">Все матчи</button> 
            <button class="w3-btn w3-round-large" onclick="location.href = '.'">На главную</button>
        </div>
    </body>
</html>