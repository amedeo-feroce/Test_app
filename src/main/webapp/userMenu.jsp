
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.acn.nemo.dto.LoginDtoInput" %>
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
    <h3>THIS IS THE FARMA_PROMO_DEF TABLE:</h3>
    <form  method="post" >

        <table border="2">
            <tr>
                <th>COD_PROMO</th><th>PGR_PROMO</th><th>PGR_RIGA</th><th>DATA_INIZIO_PROMO</th><th>DATA_FINE_PROMO</th><th>SEG_CLI</th><th>VALORE_TP</th><th>SCONTO_P</th><th>NRO_VOLTE</th><th>TIPO</th><th>TIPO_PROMO</th><th>DESCRIZIONE</th><th>INIZIATIVA</th><th>TIPO_PROMO_VS</th><th>DESC_TIPO</th><th>DT_MOD</th>
            </tr>
            <%
                try {
                    Class.forName("oracle.jdbc.OracleDriver");
                    String url = "jdbc:oracle:thin:@//10.0.0.7:1521/sic30dev";
                    String username = "c3bo_mw";
                    String password = "c3bo_mw";
                    String query = "select * from FARMA_PROMO_DEF";
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    while (rs.next()) {

            %>

            <tr>
                <td><%=rs.getInt("COD_PROMO")%></td>
                <td><%=rs.getInt("PGR_PROMO")%></td>
                <td><%=rs.getInt("PGR_RIGA")%></td>
                <td><%=rs.getDate("DATA_INIZIO_PROMO")%></td>
                <td><%=rs.getDate("DATA_FINE_PROMO")%></td>
                <td><%=rs.getString("SEG_CLI")%></td>
                <td><%=rs.getInt("VALORE_TP")%></td>
                <td><%=rs.getInt("SCONTO_P")%></td>
                <td><%=rs.getInt("NRO_VOLTE")%></td>
                <td><%=rs.getString("TIPO")%></td>
                <td><%=rs.getString("TIPO_PROMO")%></td>
                <td><%=rs.getString("DESCRIZIONE")%></td>
                <td><%=rs.getString("INIZIATIVA")%></td>
                <td><%=rs.getInt("TIPO_PROMO_VS")%></td>
                <td><%=rs.getString("DESC_TIPO")%></td>
                <td><%=rs.getDate("DT_MOD")%></td>
            </tr>
            <%--<input type="hidden" name="id" value=<%=rs.getId() %>>--%>
            <%}%>
        </table>
        <%
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            out.print(e.getMessage());%><br><%
                }%>
    </form>
    <br>
    <br><br><br><br><br><a href="LogoutController">Logout</a>
</body>
</html>
