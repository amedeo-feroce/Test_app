<%-- 
    Document   : update
    Created on : Sep 26, 2019, 2:50:12 PM
    Author     : amedeo.feroce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Table</title>
    </head>
    <body>
        <form action="UpdateController"  name="update" method="post" onsubmit="return verifica(this)">
            <center>
                <h1>Update Page</h1>
            </center>
            <label title="COD_PROMO:" >COD_PROMO</label>
            <input  type="number" name="COD_PROMO" />
        </p>
        <label title="PGR_PROMO:" >PGR_PROMO</label>
        <input  type="number" name="PGR_PROMO" />
    </p>
    <label title="PGR_RIGA:" >PGR_RIGA</label>
    <input  type="number" name="PGR_RIGA" />
</p>
<label title="DATA_INIZIO_PROMO:" >DATA_INIZIO_PROMO</label>
<input  type="date" name="DATA_INIZIO_PROMO" />
</p>
<label title="DATA_FINE_PROMO:" >DATA_FINE_PROMO</label>
<input  type="date" name="DATA_FINE_PROMO" />
</p>
<label title="SEG_CLI:" >SEG_CLI</label>
<input  type="text" name="SEG_CLI" />
</p>
<label title="VALORE_TP:" >VALORE_TP</label>
<input  type="number" name="VALORE_TP" />
</p>
<label title="SCONTO_P:" >SCONTO_P</label>
<input  type="number" name="SCONTO_P" />
</p>
<label title="NRO_VOLTE:" >NRO_VOLTE</label>
<input  type="number" name="NRO_VOLTE" />
</p>
<label title="TIPO:" >TIPO</label>
<input  type="text" name="TIPO" />
</p>
<label title="TIPO_PROMO:" >TIPO_PROMO</label>
<input  type="text" name="TIPO_PROMO" />
</p>
<label title="DESCRIZIONE:" >DESCRIZIONE</label>
<input  type="text" name="DESCRIZIONE" />
</p>
<label title="INIZIATIVA:" >INIZIATIVA</label>
<input  type="password" name="INIZIATIVA" />
</p>
<label title="TIPO_PROMO_VS:" >TIPO_PROMO_VS</label>
<input  type="number" name="TIPO_PROMO_VS" />
</p>
<label title="DESC_TIPO:" >DESC_TIPO</label>
<input  type="text" name="DESC_TIPO" />
</p>
<label title="DT_MOD:" >DT_MOD</label>
<input  type="date" name="DT_MOD" />
</p>

</body>
</form>
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
        if (document.login.data_inizio_promo.value == "") {
            verifica = true;
            alert("The data_inizio_promo field is required.");

        }
        if (document.login.data_fine_promo.value == "") {
            verifica = true;
            alert("The data_fine_promo field is required.");

        }
        if (document.login.seg_cli.value == "") {
            verifica = true;
            alert("The seg_cli field is required.");

        }
        if (document.login.valore_tp.value == "") {
            verifica = true;
            alert("The valore_tp field is required.");

        }
        if (document.login.sconto_p.value == "") {
            verifica = true;
            alert("The sconto_p field is required.");

        }
        if (document.login.nro_volte.value == "") {
            verifica = true;
            alert("The nro_volte field is required.");

        }
        if (document.login.tipo.value == "") {
            verifica = true;
            alert("The tipo field is required.");

        }
        if (document.login.tipo_promo.value == "") {
            verifica = true;
            alert("The tipo_promo field is required.");

        }
        if (document.login.descrizione.value == "") {
            verifica = true;
            alert("The descrizione field is required.");

        }
        if (document.login.iniziativa.value == "") {
            verifica = true;
            alert("The iniziativa field is required.");

        }
        if (document.login.tipo_promo_vs.value == "") {
            verifica = true;
            alert("The tipo_promo_vs field is required.");

        }
        if (document.login.desc_tipo.value == "") {
            verifica = true;
            alert("The desc_tipo field is required.");

        }
        if (document.login.dt_mod.value == "") {
            verifica = true;
            alert("The dt_mod field is required.");

        }
        if (verifica) {
            return false;
        } else {
            return true;
        }
    }
</script>
</html>
