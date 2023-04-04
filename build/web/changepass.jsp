<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Van Phuong - Blog</title>
        <link rel="stylesheet" href="s./style/forgotpass.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="https://cdn.lineicons.com/2.0/LineIcons.css" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
        </script>

    </head>
    <body class="auth_class">

        <div class="container login-container">
            <img class="triangleA" src="https://res.cloudinary.com/procraftstudio/image/upload/v1613965232/triangleA_lwqhnl.png" alt='Onestop triangle'>
            <div class="row">
                <div class="col-md-6 welcome_auth">
                    <div class="auth_welcome">Van Phuong - Blog, where we share</div>
                </div>         
                <div class="col-md-6 login-form">
                    <div class="login_form_in">
                        <div class="form-group other_auth_links">
                            <div style="background-color: #000000;width: 130px; border-radius: 10px;padding:3px 5px;" class="contain_logo">
                                <a href="home" class="original-logo"><img src="img/core-img/mylogo.png" style="width: -webkit-fill-available;" alt=""></a>
                            </div>
                        </div>
                        
                        <c:url var="change" value="change"></c:url>
                        <h1 class="auth_title text-left">Change password</h1>
                        <form action="change" method="post">
                            <div class="alert alert-success bg-soft-primary border-0" role="alert">
                                Enter your old password and new password                     
                            </div>                 
                            <div class="form-group">
                                <input type="password" class="form-control" name="oldpass" placeholder="Old password">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="newpass" placeholder="New password">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="rpnewpass" placeholder="Repeat new password">
                            </div>
                            <p id="noti" style="color: green; font-weight: 600;">${changeSuccess}</p>  
                            <p class="err" style="color: red;">${errWrongOldPass} </p> 
                            <p class="err" style="color: red;">${errRpPassNotMatch} </p> 
                            <p class="err" style="color: red;">${errNewPassNotValid} </p> 
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
                            </div>
                            
                        </form>
                    </div>
                </div>       
            </div>
        </div>

        <img class="triangleB" src="https://res.cloudinary.com/procraftstudio/image/upload/v1613965232/triangleB_isffjy.png" alt='Onestop triangle'>
    </body>

</html>
