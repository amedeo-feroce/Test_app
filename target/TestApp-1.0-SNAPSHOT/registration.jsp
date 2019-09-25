<%-- 
    Document   : registration
    Created on : Sep 11, 2019, 5:15:34 PM
    Author     : amedeo.feroce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <form action="RegisterController" method="post" onsubmit='check()'> 
            <center>
                <h1>Registration Page</h1>
            </center>
            Username: <input id='username' type="text" name="username" value="username" onclick="this.value = ''"/><br/>    
            Password: <input id='password' type="password" name="password"  value="Password" onclick="this.value = ''"/><br/>  
            Confirm Password: <input id='repassword' type="password" name="repassword"  value="RePassword" onclick="this.value = ''"/><br/>
            

            <p id='errore'></p>
    </body>
    <br><input type="submit" value="Register"/><br>
        </form> 
    <h3>or</h3><a href="javascript:history.back()">Go back</a>

<script>
    function check() {
        var usernme = document.getElementById('username').value;
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        var repassword = document.getElementById('repassword').value;

        var errore = true;

        
        //primo controllo
        if (repassword != password) {
            errore = true;
        }
        
        if (errore) {
            document.getElementById('errore').innerHTML = "errore"
            return errore;
        } else {
            return errore;
        }
    }
</script>
</html>
