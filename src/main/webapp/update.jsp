<%-- 
    Document   : update
    Created on : Sep 26, 2019, 2:50:12 PM
    Author     : amedeo.feroce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.acn.nemo.dto.UpdateDtoInput" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Table</title>
        <%String choice = (String) session.getAttribute("choice"); %>
        <%int id = Integer.parseInt(request.getParameter("id")); %>
        
    </head>
    <body>
        <form action="UpdateController"  name="update" method="post" onsubmit="return verifica(this)">
            <center>
                <h1>Update Page</h1>
            </center>

            <% if (choice.equals("u"))
            {%>

            <label title="ID" >ID</label>
            <input  type="number" name="id" value="<%=id%>" readonly />
        </p>
        <label title="COD_PROMO:" >COD_PROMO</label>
        <input  type="number" name="cod_promo"  />
    </p>
    <label title="PGR_PROMO:" >PGR_PROMO</label>
    <input  type="number" name="pgr_promo" />
</p>
<label title="PGR_RIGA:" >PGR_RIGA</label>
<input  type="number" name="pgr_riga" />
</p>

<label title="SCONTO_P:" >SCONTO_P</label>
<input  type="number" name="sconto_p" />
</p>

<label title="TIPO_PROMO:" >TIPO_PROMO</label>
<input  type="text" name="tipo_promo" />
</p>
<label title="DESCRIZIONE:" >DESCRIZIONE</label>
<input  type="text" name="descrizione" />
</p>

<label title="DESC_TIPO:" >DESC_TIPO</label>
<input  type="text" name="desc_tipo" />
</p>
<input type="hidden" name="op" value="updated">
<%
} 
%>

<input type="submit" value="Continue"><br>

</form>
</body>
<script type="text/javascript">
    function verifica() {
        var verifica = false;
        if (document.update.cod_promo.value == "") {
            verifica = true;
            alert("The cod_promo field is required.");
        }
        if (document.login.pgr_promo.value == "") {
            verifica = true;
            alert("The pgr_promo field is required.");

        }
        if (document.login.pgr_riga.value == "") {
            verifica = true;
            alert("The pgr_riga field is required.");

        }

        if (document.login.sconto_p.value == "") {
            verifica = true;
            alert("The sconto_p field is required.");

        }

        if (document.login.tipo_promo.value == "") {
            verifica = true;
            alert("The tipo_promo field is required.");

        }
        if (document.login.descrizione.value == "") {
            verifica = true;
            alert("The descrizione field is required.");

        }
        if (document.login.desc_tipo.value == "") {
            verifica = true;
            alert("The desc_tipo field is required.");

        }
        if (verifica) {
            return false;
        } else {
            return true;
        }
    }
</script>
</html>
