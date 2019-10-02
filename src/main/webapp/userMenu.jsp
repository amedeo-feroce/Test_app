
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.acn.nemo.dto.LoginDtoInput" %>
<%@page import="com.acn.nemo.dto.UpdateDtoInput" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
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
    <h3>THIS IS THE FARMA_PROMO_TEST TABLE:</h3>
    <form action="FarmaController" method="post" >

        <table border="2">
            <tr>
                <th>ID</th><th>COD_PROMO</th><th>PGR_PROMO</th><th>PGR_RIGA</th><th>SCONTO_P</th><th>TIPO_PROMO</th><th>DESCRIZIONE</th><th>DESC_TIPO</th><th>UPDATE</th><th>DELETE</th>
            </tr>
            <%
                try {
                    Class.forName("oracle.jdbc.OracleDriver");
                    String url = "jdbc:oracle:thin:@//10.0.0.7:1521/sic30dev";
                    String username = "c3bo_mw";
                    String password = "c3bo_mw";
                    String query = "select * from FARMA_PROMO_TEST";
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    while (rs.next()) {

            %>

            <tr>
                <td><%=rs.getInt("ID")%></td>
                <td><%=rs.getInt("COD_PROMO")%></td>
                <td><%=rs.getInt("PGR_PROMO")%></td>
                <td><%=rs.getInt("PGR_RIGA")%></td>
                <td><%=rs.getInt("SCONTO_P")%></td>
                <td><%=rs.getString("TIPO_PROMO")%></td>
                <td><%=rs.getString("DESCRIZIONE")%></td>
                <td><%=rs.getString("DESC_TIPO")%></td>
                

                <td><input type="radio" onclick="window.location = 'FarmaController?op=update';">UPDATE</td>
                <td><input type="radio" onclick="window.location = 'FarmaController?op=delete';">DELETE</td>

            </tr>

            <%}%>
        </table>
        <%
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            out.print(e.getMessage());%><br><%
                }%>

        <br>

        </body>
    </form>
    <br><br><br><br><br><a href="LogoutController">Logout</a>
</html>
