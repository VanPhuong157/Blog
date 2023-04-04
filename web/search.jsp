<%@include file="template/header.jsp" %>
         <!--##### Blog Wrapper Start #####--> 
        <div class="blog-wrapper section-padding-50 clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-lg-10">
                        <c:if test="${requestScope.listPostFind.size() == 0}">
                            <h2 style="margin-bottom: 40px; color: #666;">
                                No result found for "${requestScope.searchname}"</h2>
                        </c:if>
                        <c:if test="${requestScope.listPostFind.size() > 0}">   
                            <h3 style="margin-bottom: 40px; color: #666;" id="postFound">
                                The number of result is ${requestScope.listPostFind.size()}</h3>
                        <c:forEach items="${listPostFind}" var="x">
                         <!--Single Blog Area-->  
                        <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.2s"
                             data-wow-duration="1000ms">
                            <div class="row align-items-center">
                                <div class="col-12 col-md-6">
                                    <div class="single-blog-thumbnail">
                                        <img src="postimg/${x.getImage()}" alt="">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                     <!--Blog Content--> 
                                    <div class="single-blog-content">
                                        <div class="line"></div>
                                        
                                        <h4><a href="post?postId=${x.getPostID()}" class="post-headline">${x.getStatus()}</a></h4>
                                        <span class="post-previewContent">${x.getContent()}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                         </c:if> 
                    </div>
                </div>
            </div>
        </div>
         <!--##### Blog Wrapper End #####--> 

         

         <!--##### Footer Area Start #####--> 
        <footer class="footer-area text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="classy-nav-container breakpoint-off">
                            <nav class="classy-navbar justify-content-center">
                                <div class="classy-menu">
                                    <div class="classynav">
                                        <ul>
                                            <li><a href="../home">Home</a></li>
                                            <li><a href="aboutme.jsp">About Us</a></li>
                                            <li><a href="contact.jsp">Contact</a></li>
                                            <c:if test="${sessionScope.account != null}">
                                                <li><a href="changepass.jsp">Change password</a></li>
                                            </c:if>
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
        <!-- ##### Footer Area End ##### -->

        <!-- jQuery (Necessary for All JavaScript Plugins) -->
        <script src="./js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="./js/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="./js/bootstrap.min.js"></script>
        <!-- Plugins js -->
        <script src="./js/plugins.js"></script>
        <!-- Active js -->
        <script src="./js/active.js"></script>
    </body>

</html>
