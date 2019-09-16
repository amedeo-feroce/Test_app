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
        <form action="" method="">  
            Username: <input type="text" name="username" value="Name" onclick="this.value = ''"/><br/>  
            Email: <input type="text" name="email"  value="Email" onclick="this.value = ''"/><br/>  
            Password: <input type="password" name="password"  value="Password" onclick="this.value = ''"/><br/>  
            <input type="button" value="register"/><br>
            <a href="javascript:history.back()">Go back</a>
        </form>  
    </body>
</html>
