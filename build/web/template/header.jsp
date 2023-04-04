

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Van Phuong - Blog</title>
        <link rel="stylesheet" href="./style//newstyle.css">
        <link rel="stylesheet" href="./style/myadmin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.ckeditor.com/ckeditor5/34.1.0/classic/ckeditor.js"></script>
    </head>
    <body>
        <c:if test="${requestScope.cf_delete != null}">
            <div id="wrapcf" class="wrap_confirm">
                <div class="box_confirm">
                    <h2 class="messcf">${requestScope.cf_delete}</h2>
                    <div class="containBtn">
                        <button onclick="handleCancel()" class="cancelBtn">Cancel</button>
                        <form method="post">
                            <button type="submit" class="delBtn">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>
        <!--##### Header Area Start #####--> 
        <header class="header-area">
            <!--Nav Area--> 
            <div class="original-nav-area" id="stickyNav">
                <div class="classy-nav-container breakpoint-off">
                    <div class="container">
                        <!--Classy Menu--> 
                        <nav class="classy-navbar justify-content-between">
                            <div class="contain_logo">
                                <a href="home" class="original-logo"><img src="./img/core-img/mylogo.png" alt=""></a>
                            </div>

                            <!--Menu--> 
                            <div class="classy-menu" id="originalNav">
                                <!--Nav Start--> 
                                <div class="classynav">
                                    <ul>
                                        <c:if test="${sessionScope.account.getRoleID() == 1}"> 
                                            <li><a href="create">Create post</a></li>
                                            <li><a href="dashboard">Dashboard</a></li>
                                            </c:if>
                                        <li><a href="home">Home</a></li>
                                        <li><a href="aboutme.jsp">About Us</a></li>
                                        <li><a href="contact.jsp">Contact</a></li>
                                            <c:if test="${sessionScope.account != null}">
                                            <li><a href="change">Change password</a></li>
                                            </c:if>
                                        <li>
                                            <c:if test="${sessionScope.account != null}">
                                                <a href="logout">Log out</a>
                                            </c:if>
                                            <c:if test="${sessionScope.account == null}">
                                                <a href="login">Log in</a>
                                            </c:if>
                                        </li>
                                    </ul>
                                </div>
                                <!--Nav End--> 
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
       
        <!--##### Header Area End #####--> 