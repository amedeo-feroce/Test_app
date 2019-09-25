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
        <form action="RegisterController" name="registration" method="post" onsubmit="return check(this)"> 
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

<script type="text/javascript">
    function check() {
        var errore = false;
        
         if (document.registration.username.value == "") {
            errore = true;
            alert("The Username field is required.");
        }
        if (document.registration.password.value == "") {
            errore = true;
            alert("The password field is required.");
        }
        // Verifico che le due password siano uguali, in caso contrario avverto
        // dell'errore con un Alert
        if (document.registration.password.value != document.registration.repassword.value) {
            errore=true;
            alert("Your password and confirmation password do not match");
            
        }
        if (errore) {
            return false;
        } else {
            return true;
        }
    }
</script>
</html>
