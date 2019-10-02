<%-- 
    Document   : getChoice
    Created on : Sep 30, 2019, 11:05:19 AM
    Author     : amedeo.feroce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>get Choice</title>
        <%String choiceControl = (String) session.getAttribute("choiceControl"); %>
    </head>
    <body>
        <form action="FarmaController" method="post"> 
            ID: <input type="number" name="id" value="" required><br>
            <%
                if (choiceControl.equals("cu")) {%>
            <input type="hidden" name="op" value="control_upd">
            <%} else if (choiceControl.equals("cd")) {%>
            <input type="hidden" name="op" value="control_del">
            <%}%>
            <input type="submit" value="Enter"><br>
            </body>
            </html>
