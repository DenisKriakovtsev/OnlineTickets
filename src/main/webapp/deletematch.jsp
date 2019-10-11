<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Matches"%>
<html>
    <head>
        <title>Удаление матча</title> 
          <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey"> 
        <div class="w3-container w3-black w3-opacity w3-right-align">           
            <h1>Удаление матча</h1>
        </div>

        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">              
                <form method="post">
                    <h3>Выберите матч</h3>
                    <div>
                        <select class="w3-transparent w3-select" name="match">
                            <%
                                List<Matches> matcheses = (List<Matches>) request.getAttribute("ListMatches");
                                for (Matches match : matcheses) {
                            %>
                            <option value="<%=match.getId()%>"><%=match.getNamematches()%>
                                <%
                                    }
                                %>

                        </select>
                    </div>
                           <br/>
                    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Удалить</button>
                </form>

            </div>
        </div>
        <div class="w3-container w3-black w3-bottom w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href = './ShowMatch'">Матчи</button>
            <button class="w3-btn w3-round-large" onclick="location.href = '.'">На главную</button>
        </div>
    </body>
</html>