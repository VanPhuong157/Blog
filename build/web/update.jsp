<%-- 
    Document   : update
    Created on : Jun 23, 2022, 4:51:35 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" type="image/x-icon" href="../img/core-img/favi.jpg">
        <title>Van Phuong - Blog</title>
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
                                <a href="home" class="original-logo"><img src="img/core-img/mylogo.png" alt=""></a>
                            </div>

                            <!--Menu--> 
                            <div class="classy-menu" id="originalNav">
                                <!--Nav Start--> 
                                <div class="classynav">
                                    <ul>
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
                <h2>Update post</h2>
                <div class="form_post">
                    <form method="post"  action="update">
                        <label class="lable" for="title">CateforyName:</label> 
                         <select name="cateId">
                            <c:forEach items="${listCate}" var="ca">
                                <c:if test="${ca.getCategoryID()==postUpdated.getCategoryID()}">
                                    <option value="${ca.getCategoryID()}" selected>${ca.getCategoryName()}</option>
                                </c:if>
                                <c:if test="${ca.getCategoryID()!=postUpdated.getCategoryID()}">
                                    <option value="${ca.getCategoryID()}">${ca.getCategoryName()}</option>
                                </c:if>
                            </c:forEach>
                        </select><br/>
                        <label class="lable" for="title">Title</label> <br>
                        <input id="title" type="text" name="status" value="${requestScope.postUpdated.getStatus()}"  placeholder="Type your title"><hr>
                        <label class="lable" for="hastag">Hastag</label> <br>
                        <input id="hastag" type="text" name="hastag" placeholder="Type your hastag ex:#footbal #story..."  value="${requestScope.postUpdated.getHastag()}"><hr>
                        <p style="color: red; font-size: 16px;">${requestScope.errWrongFormHastag}</p>
                        <label class="lable" for="image">Upload your image</label> <br>
                        <input type="file" value="${requestScope.postUpdated.getImage()}" name="image" id="image"/> <hr>     
                        <label class="lable"  for="editor">Content</label> <br>
                        <textarea name="content" id="editor" cols="75" rows="10" placeholder="Type your content">
                            ${requestScope.postUpdated.getContent()}
                        </textarea> <hr>
                        <button id="btn_createpost" type="submit">submit</button>
                        <p style="color: red;">${requestScope.errBlank}</p>
                        <input type="hidden" name="updateId" value="${postUpdated.getPostID()}">
                    </form>
                </div>
            </div>
        </div>
        <div>${requestScope.content}</div>
        <div>${requestScope.title}</div>
        <div>${requestScope.image}</div>

        <footer class="footer-area text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="classy-nav-container breakpoint-off">
                            <nav class="classy-navbar justify-content-center">
                                <div class="classy-menu">
                                    <div class="classynav">
                                        <ul>
                                            <li><a href="home">Home</a></li>
                                            <li><a href="aboutme.jsp">About Us</a></li>
                                            <li><a href="contact.jsp">Contact</a></li>
                                             <li><a href="changepass.jsp">Change password</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                        </div>

                        <!--Footer Social Area--> 
                        <div class="footer-social-area mt-30">
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook" 
                                                                                                       aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Twitter"><i class="fa fa-twitter"
                                                                                                      aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Instagram"><i class="fa fa-instagram" 
                                                                                                        aria-hidden="true"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            Copyright &copy;
            <script>document.write(new Date().getFullYear());</script> by Nguyen Van Phuong <i class="fa fa-heart-o"
                                                                                               aria-hidden="true"></i>
        </footer>
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
    </body>
</html>
