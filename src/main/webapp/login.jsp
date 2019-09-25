<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="LoginController" name="login" method="post" onsubmit="return verifica(this)">
            <center>
                <h1>Login Page</h1>
            </center>
            <label title="Username:" >Username</label>
            <input  type="text" name="username" />
        </p>
        <label title="Password:" >Password</label>
        <input id=password type="password" name="password" />
    </p>
    <input type="checkbox" onclick="showPassword()">Show Password
    </body>
    </p>
    <input type="submit" value="Login" ><br>
    <br>
</form>

    <h2>or</h2><a href="registration.jsp">SIGN UP</a><br>

<script type="text/javascript">

    function verifica() {
        var verifica = false;
        if (document.login.username.value == "") {
            verifica = true;
            alert("The Username field is required.");
        }
        if (document.login.password.value == "") {
            verifica = true;
            alert("The password field is required.");

        }
        if (verifica) {
            return false;
        } else {
            return true;
        }
    }
    function showPassword() {
        var x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>

</html>
