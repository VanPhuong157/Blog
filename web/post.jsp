<%@include file="template/header.jsp" %>
<!--content-->
<div class="content-item" id="comments">
    <div class="container">
        <div class="row align-items">
            <div class="col-12 col-md-12">
                <div class="blog-wrapper section-padding-100-0 clearfix">
                    <div class="container">
                        <div class="row align-items-end">
                            <!-- Single Blog Area -->
                            <div class="col-12 col-lg-6">
                                <div class="single-blog-area clearfix mb-100">
                                    <!-- Blog Content -->
                                    <div class="single-blog-content">
                                        <div class="line"></div>
                                        <h1 class="post-headline">${requestScope.post.getStatus()}</h1>
                                        <p class="mb-3">${requestScope.post.getDate()}</p>

                                    </div>
                                </div>
                            </div>
                            <!-- Single Blog Area -->
                            <div class="col-12 col-md-6 col-lg-6">
                                <div class="single-catagory-area clearfix mb-100">
                                    <img src="postimg/${requestScope.post.getImage()}" alt="">

                                </div>
                            </div>
                        </div>
                    </div>

                    <!--content-->
                    <div class="container">
                        <div class="row align-items-end">
                            <!-- Single Blog Area -->
                            <div class="col-12 col-md-12">
                                <div class="single-blog-area clearfix mb-100">
                                    <!-- Blog Content -->
                                    <div class="single-blog-content">
                                        <p class="mb-3">${requestScope.post.getContent()}</p>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <!--hastag-->
                    <div class="container">
                        <div class="row align-items-end">
                            <!-- Single Blog Area -->
                            <div class="col-12 col-md-12">
                                <div class="single-blog-area clearfix mb-100">
                                    <!-- Blog Content -->
                                    <div class="single-blog-content">
                                        <c:forEach var="i" items="${requestScope.arrhastag}">
                                            <a href="search?search=${i.replace("#","")}" class="mb-3">${i}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <form action="comment" method="post">
                    <h3 class="pull-left">
                        <i class="far fa-comment-alt"></i> Comment</h3>
                    <fieldset>
                        <div class="row">
                            <input type="hidden" name="postid" value="${requestScope.post.getPostID()}" >
                            <div class="col-sm-3 col-lg-1 hidden-xs">
                                <img class="img-responsive" src="../img/core-img/avtcomment.png" alt="">
                            </div>
                            <div class="form-group col-xs-12 col-sm-9 col-lg-10">
                                <textarea class="form-control" name="comment" id="message" placeholder="Your comment"
                                          required=""></textarea>
                            </div>
                            <button type="submit" class="btn btn-normal pull-right">Submit</button>

                        </div>
                    </fieldset>
                </form>
                <h3>${requestScope.listcmt.size()} 
                    <i class="far fa-comment-alt"></i> Comments
                </h3>
                <c:forEach items="${requestScope.listcmt}" var="x">
                    <!-- COMMENT 1 - START -->
                    <div class="media">
                        <a class="pull-left" href="#"><img class="media-object"
                                                           src="../img/core-img/avtcomment.png" alt=""></a>
                        <div class="media-body">
                            <h4 class="media-heading">${dao.getAccount(x.getUserID()).getName()}</h4>
                            <p class="comment_content">${x.getComment()}</p>
                            <ul class="list-unstyled list-inline media-detail pull-left">
                                <li>${x.getDate()}</li>
                            </ul>
                            <c:if test="${sessionScope.account.getRoleID() == 1}"> 
                                <div class="single-blog-content-head-items">
                                    <a><a href="delete?postid=${requestScope.post.getPostID()}&deleteId=${x.getCommentID()}">
                                            <i class="fas fa-trash"></i>
                                        </a>    
                                </div>

                            </c:if>    

                        </div>
                    </div>
                </c:forEach>
                <!-- COMMENT 1 - END -->

            </div>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>


<script>
    function handleCancel() {
        document.getElementById('wrapcf').style.visibility = "hidden"
    }
</script>