

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="icon" type="image/x-icon" href="../img/core-img/favi.jpg">
        <title>Van Phuong- Blog</title>
        <link rel="stylesheet" href="./style/myadmin.css">
        <script src="https://cdn.ckeditor.com/ckeditor5/34.1.0/classic/ckeditor.js"></script>

    </head>
    <body>

        <!--##### Header Area Start #####--> 
        <header class="header-area">

            <!--Nav Area--> 
            <div class="original-nav-area" id="stickyNav">
                <div class="classy-nav-container breakpoint-off">
                    <div class="container">
                        <!--Classy Menu--> 
                        <nav class="classy-navbar justify-content-between">
                            <div class="contain_logo">
                                <a href="#" class="original-logo"><img src="img/core-img/mylogo.png" alt=""></a>
                            </div>

                            <!--Menu--> 
                            <div class="classy-menu" id="originalNav">
                                <!--Nav Start--> 
                                <div class="classynav">
                                    <ul>
                                        <li><a href="">Create post</a></li>
                                        <li><a href="home">Home</a></li>
                                        <li><a href="aboutme.jsp">About Us</a></li>
                                        <li><a href="contact.jsp">Contact</a></li>
                                        <li><a href="changepass.jsp">Change password</a></li>
                                            <c:if test="${sessionScope.account != null}"> 
                                            <li><a href="logout">Log out</a></li>
                                            </c:if>
                                    </ul>
                                </div>
                                <!--Nav End--> 
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="col-12 offset-lg-2 col-lg-8">
                <h2>Create post</h2>
                <div class="form_post">
                    <form method="post"  action="create">
                        <label class="lable" for="title">CateforyName:</label> 
                         <select name="cateId">
                            <c:forEach items="${listCate}" var="ca">
                                <option value="${ca.getCategoryID()}">${ca.getCategoryName()}</option>
                            </c:forEach>
                        </select><br/>
                        <label class="lable" for="title">Status</label> <br>
                        <input id="title" type="text" name="status" placeholder="Type your status" ><hr>
                        <label class="lable" for="hastag">Hastag</label> <br>
                        <input id="hastag" type="text" name="hastag" placeholder="Type your hastag ex:#footbal #story..." ><hr>
                        <label class="lable" for="image">Upload your image</label> <br>
                        <input type="file" name="image"  id="image"/> <hr>     
                        <label class="lable" for="editor">Content</label> <br>
                        <textarea name="content" id="editor" cols="75" rows="10" placeholder="Type your content" ></textarea> <hr>
                        <p style="color: red; font-size: 16px;">${requestScope.errWrongFormHastag}</p>
                        <p style="color: red; font-size: 16px;">${requestScope.errEmptyImage}</p>
                        <button id="btn_createpost" type="submit">submit</button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="template/footer.jsp" %>

        <script>
            var value;
            ClassicEditor
                    .create(document.querySelector('#editor'))
                    .then(editor => {
                        value = editor;
                    })
                    .catch(error => {
                        console.error(error);
                    });

            const handleSubmit = () => {
                document.getElementById('a').innerHTML = value.getData()
            }
        </script>
