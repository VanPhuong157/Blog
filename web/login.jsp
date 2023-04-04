<%-- 
    Document   : login
    Created on : Apr 23, 2022, 4:50:22 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="./style/login.css">
        <link rel="icon" type="image/x-icon" href="../img/core-img/favi.jpg">

    </head>
    <body>
        <div class="wrapper">
            <div class="title">
                <div class="sub_title">Login</div>
                <div class="sub_title"><a href="signup">Sign up</a></div>
            </div>

            <div class="input_info">
                <form ation="login" method="post">
                    <label class="lable" for="username">Username</label> <br>
                    <input class="input_space" id="username" type="text" value="${cookie.user.value}" name="user" 
                           placeholder="Type your username">
                    <br>
                    <label class="lable" for="password">Password</label> <br>
                    <input class="input_space" type="password" id="password" name="pass" value="${cookie.pass.value}" 
                           placeholder="Type your password">
                    <br>
                    <input type="checkbox" id="htmlcheckbox" name="rem" ${(cookie.rem.value eq 'ON') ? "checked" : ""} value="ON">
                    <label for="htmlcheckbox">Remember me</label><br>
                  
                    <p>${requestScope.errAccNotExist}</p>
                    <p>${requestScope.loginToComment}</p>
                    <p id="noti" style="color: green; font-weight: 600;">${requestScope.verifySuccess}
                    <p id="noti" style="color: green; font-weight: 600;">${requestScope.activeSuccess}
                    </p>

                    <input type="submit" value="LOGIN" id="btn_login">
                </form>
            </div>
        </div>
        <script>
//            if have error, alert it
            if("${requestScope.errNotLogin}" !== "")
                alert("${requestScope.errNotLogin}");
        </script>
    </body>
</html>
