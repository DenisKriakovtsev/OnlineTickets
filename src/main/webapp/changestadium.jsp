<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Stadium"%>
<html>
    <head>
        <title>Изменение данных</title> 
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-black w3-opacity w3-right-align">
            <h1 style="text-shadow:1px 1px 0 #444">Изменение стадиона</h1>
        </div>

        <div class="w3-container w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2 style="text-shadow:1px 1px 0 #333">Стадион</h2>
                </div>
                <%
                    if (request.getAttribute("ChangeData") != null) {
                        out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                                + "   <span onclick=\"this.parentElement.style.display='none'\"\n"
                                + "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n"
                                + "   <h5>Изменено на: " + request.getAttribute("ChangeData") + "!</h5>\n"
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
                <form method="post" id="form" class="w3-selection w3-animate-left w3-light-grey w3-padding">
                    <div>
                        <%
                            String id = request.getParameter("id");
                            String name = request.getParameter("name");
                            String numberofseats = request.getParameter("numberofseats");
                            String city = request.getParameter("city");
                            String datecreate = request.getParameter("datecreate");
                        %>
                        <div class="form-row">
                            <label>Название стадиона</label>
                            <input type="text" class="w3-input w3-animate-input" 
                                   value="<%=name%>" name="uname" style="width:30%">
                            <label>Количество мест</label>
                            <input type="text"  class="w3-input w3-animate-input" 
                                   value="<%=numberofseats%>" name="unumberofseats" style="width:30%"> 
                            <label>Дата создания</label>
                            <input type="date"  class="w3-input w3-animate-input" 
                                   value="<%=datecreate%>" name="udatecreate" style="width:30%"> 
                            <label>Город</label>
                            <input type="text"  class="w3-input w3-animate-input"
                                   value="<%=city%>" name="ucity" style="width:30%">
                        </div>
                        <input type="hidden" value="<%=id%>" name="uid">
                        <br />
                        <input type="submit" class="w3-btn w3-green w3-round-large edit" value="Редактировать">
                    </div> 
                </form>
                <!---------------------------------------------------------------------------------------------------->
            </div>
        </div>
        <div class="w3-container w3-black w3-bottom w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href = './ShowStadiums'">Назад</button>              
            <button class="w3-btn w3-round-large" onclick="location.href = '.'">На главную</button>
        </div>
        <script src="js/script.js"></script>
    </body>
</html>