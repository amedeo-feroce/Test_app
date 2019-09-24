
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.acn.nemo.dto.LoginDtoInput" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Menu</title>
        <%LoginDtoInput loginDto =(LoginDtoInput) session.getAttribute("user"); %>
    </head>
    <body>
        <center><h2>Home Page</h2></center>
         
        <div id=center>
            <h3>Welcome <%=loginDto.getUsername()%></h3>
            
            <a href="LogoutController">Logout</a></div>
    </body>
</html>
