<%@ page import="java.util.List" %>
<%@ page import= "model.Stadium" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Список стадионов</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script  src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css"> 	
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-black w3-opacity w3-right-align">
            <h1>Онлайн покупка билетов</h1>

        </div>

        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-card-4">
                    <div class="optionStadium">
                        <button class="w3-btn w3-animate-left w3-dark-grey w3-right-align w3-round-large" onclick="location.href = './AddServlet'">Добавить стадион</button>
                        <button class="w3-btn w3-animate-right w3-dark-grey w3-right-align w3-round-large" onclick="location.href = './DeleteStadium'">Удалить стадион</button>
                    </div>
                    <h1 style="text-shadow:1px 1px 0 #fff">Стадионы</h1>

                </div> 
                <%
                    List<Stadium> stadiums = (List<Stadium>) request.getAttribute("ListStadiums");

                    if (stadiums != null && !stadiums.isEmpty()) {
                        out.println("<ul class=\"w3-ul\">");
                        for (Stadium stad : stadiums) {
                            out.println("<li class='w3-animate-left'>");
                            out.println("<h3>" + stad.getName() + "</h3>");
                            out.println("<h4> Город: " + stad.getCity() + "</h4>");
                            out.println("<h4> Вместимость: " + stad.getNumberofseats() + " человек</h4>");
                            out.println("<h4> Дата создания: " + stad.getDatecreate() + "</h4>");

                            out.println("<form method='post' id='form2' action='ShowMatch'>");
                            out.println("<input type='hidden' name='id_stad' value=" + stad.getId() + ">");
                            out.println("<input type='submit' class='w3-btn w3-green w3-round-large' value='Выбрать матч'>");
                            out.println("</form>");

                            out.println("<form method='GET' id='form' action='ChangeStadium'>");
                            out.println("<input hidden name='name' value=" + stad.getName() + ">");
                            out.println("<input hidden name='id' value=" + stad.getId() + ">");
                            out.println("<input hidden name='numberofseats' value=" + stad.getNumberofseats() + ">");
                            out.println("<input hidden name='city' value=" + stad.getCity() + ">");
                            out.println("<input type='hidden' name='datecreate' value=" + stad.getDatecreate() + ">");
                            out.println("<input type='submit' class='w3-btn w3-red w3-round-large' value='Изменить стадион'>");
                            out.println("</form>");

                            out.println("</li>");
                        }
                        out.println("</ul>");
                    } else {
                        out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                                + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                                + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n"
                                + "   <h5>Стадионы не найдены</h5>\n"
                                + "</div>");
                    }
                %>

            </div>
        </div>
        <div class="w3-container w3-black w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href = '.'">На главную</button>
        </div>  
    </body>
</html>