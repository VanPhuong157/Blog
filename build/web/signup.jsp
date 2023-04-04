

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <link rel="stylesheet" href="./style/signup.css">
        <link rel="icon" type="image/x-icon" href="../img/core-img/favi.jpg">


    </head>
    <body>
        <div class="wrapper">
            <div class="title">
                <div class="sub_title"><a id="login_link" href="login">Login</a></div>
                <div class="sub_title">Sign up</div>
            </div>

            <div class="input_info">
                <form  action="signup" method="post">
                    <label class="lable" for="fullname">Full name</label> <br>
                    <input class="input_space" id="fullname" type="text" name="fullname" placeholder="Type your fullname">
                    <br>
                    <label class="lable" for="username">Username</label> <br>
                    <input class="input_space" id="username" type="text" name="username" placeholder="Type your username" value="${sessionScope.user}">
                    <br>
                    <label class="lable" for="password">Password</label> <br>
                    <input class="input_space" type="password" id="password" name="password" placeholder="Type your password" value="">
                    <br>
                    <label class="lable" for="cf_password">Confirm Password</label> <br>
                    <input class="input_space" type="password" id="cf_password" name="cf_pass" placeholder="Repeat your password" value="">
                    <br>
                    <p class="errInput" style="color: red;">${requestScope.errInvalidInput}</p>
                    <p class="errInput" style="color: red;">${requestScope.errEmpty}</p>
                    <p class="errInput" style="color: red;">${requestScope.errPassNotMatch}</p>
                    <p class="errInput" style="color: red;">${requestScope.errUserNameExisted}</p>
                    <p class="errInput" style="color: green;">${requestScope.successfully}</p>
                    <input type="submit" value="SIGN UP" id="btn_login">
                </form>
            </div>
        </div>
                    
    </body>
</html>
