
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.acn.nemo.dto.LoginDtoInput" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Menu</title>
        <%LoginDtoInput loginDto = (LoginDtoInput) session.getAttribute("user");%>
    </head>
    <body>
    <center><h2>Home Page</h2></center>


    <h3>Welcome <%=loginDto.getUsername()%></h3>
    <form action=' ' method= ></form>
    <table align='left' border='1'>
        <tr>
            <td><input type='radio' name='radio1' value='1'></td>
            <td><input type='text' name='usernme'></td>
            <td><input type='text' name='password'></td>

        </tr>
        <tr>
            <td><input type='radio' name='radio1' value='1'></td>
            <td><input type='text' name='username'></td>
            <td><input type='text' name='surname'></td>

        </tr>
        <tr>
            <td><input type='radio' name='radio1' value='1'></td>
            <td><input type='text' name='username'></td>
            <td><input type='text' name='surname'></td>


        </tr>
    </table>
    </form>
    <br>
    <br><br><br><br><br><a href="LogoutController">Logout</a>
</body>
</html>
