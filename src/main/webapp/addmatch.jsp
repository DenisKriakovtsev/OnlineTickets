<%@page import="java.util.List"%>
<%@page import="model.Stadium"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Новый матч</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-black w3-opacity w3-right-align">
            <h1>Добавление нового матча</h1>
        </div>

        <div class="w3-container w3-padding">
            <%
                if (request.getAttribute("AddMatch") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                            + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                            + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n"
                            + "   <h5>Добавлен новый матч '" + request.getAttribute("AddMatch") + "!</h5>\n"
                            + "</div>");

                }
                 if (request.getAttribute("Error") != null) {
                        out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                                + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                                + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n"
                                + "   <h5>" + request.getAttribute("Error") + "!</h5>\n"
                                + "</div>");

                    }                 
            %>

            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>Добавить матч</h2>
                </div>
                <form method="post" class="w3-selection w3-light-grey w3-padding">
                    <label>Название матча
                        <input type="text" name="namematch" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>                  
                    <label>Дата проведения матча
                        <input type="datetime-local" name="dateBegin" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <label>Цена (грн)
                        <input type="text" name="price" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <h3>Выберите стадион</h3>
                    <div>
                        <select name="stad" class="w3-transparent w3-select">   
                            <%
                                List<Stadium> stadiums = (List<Stadium>) request.getAttribute("ListStadiums");
                                for (Stadium stad : stadiums) {
                            %>
                            <option value="<%=stad.getName()%>"><%=stad.getName()%>
                                <%
                                    }
                                %>
                        </select>
                    </div>
                    <br />
                    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Создать матч</button>
                </form>
            </div>
        </div>

        <div class="w3-container w3-black w3-bottom w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href = '.'">На главную</button>
        </div>
    </body>
</html>