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
                                            <li><a href="home">Home</a></li>
                                            <li><a href=view/aboutme.jsp">About Us</a></li>
                                            <li><a href="view/contact.jsp">Contact</a></li>
                                            <c:if test="${sessionScope.account != null}">
                                                <li><a href="view/changepass.jsp">Change password</a></li>
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
        <script>
                function handleCancel() {
                    document.getElementById('wrapcf').style.visibility = "hidden"
                }
        </script>
    </body>

</html>
