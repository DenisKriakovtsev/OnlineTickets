<%@page import="hbn.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page import="java.util.List" %>
<%@ page import= "model.Stadium" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Онлайн шоп</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
        <link rel="stylesheet" type="text/css" href="css/style.css"> 	
    </head>

    <body class="w3-light-grey mainPage">
        <div class="w3-container w3-black w3-opacity w3-right-align">
            <h1>Онлайн покупка билетов</h1>
        </div>

        <div class="w3-container w3-center">
            <div class="w3-bar w3-padding-large w3-padding-24">
                <br />
                  <h1 class="titleMain">Успей купить билет!</h1>
                <br /><br />
                <button class="w3-btn w3-animate-zoom w3-green w3-round-large" onclick="location.href = './ShowStadiums'">Выбрать стадион</button> 
                <button class="w3-btn w3-animate-zoom w3-green w3-round-large" onclick="location.href = './ShowFans'">Показать фанатов</button>
            </div>
        </div> 

    </body>
</html>
