<%@include file="template/header.jsp" %>
<!--##### Blog Wrapper Start #####--> 
<form action="home" method="post" >
    <input type="date" name="date">
    <input type="submit" value="Button">
</form>
<form action="home" method="post" >
    <label class="lable" for="title">CateforyName:</label> 
    <select name="cateId" style="width: 150px">
        <c:forEach items="${listCate}" var="ca">
            <option value="${ca.getCategoryID()}">${ca.getCategoryName()}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Button">
</form>
<div class="blog-wrapper section-padding-50 clearfix">
    <div class="container">
        <div class="row align-items-end">
            <!--Single Blog Area--> 
            <div class="col-12 col-lg-6">
                <div class="single-blog-area clearfix mb-100">
                    <!--Blog Content--> 
                    <div class="single-blog-content">
                        <div class="line"></div>
                        <p class="post-tag">Where we share</p>
                        <h4 class="post-headline">Welcome to Van Phuong - blog</h4>
                        <p class="mb-3">Hello guys, first of all I'm so glad you're here. This is my blog where 
                            I write post and share my experiences, story or something interesting with you all.
                            This is a place where I can express my feelings or entertain through articles, 
                            I also hope you will enjoy it, and this blog will reach more people. Thank you!</p>
                    </div>
                </div>
            </div>
            <!--Single Blog Area--> 
            <div class="col-12 col-md-6 col-lg-6">
                <div class="single-catagory-area clearfix mb-100">
                    <img src="../img/core-img/imghome.jpg" alt="">
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-9">
                <c:if test="${requestScope.listpost.size() > 0}">
                    <c:forEach items="${requestScope.listpost}" var="x" begin="${cp.begin}" end="${cp.end}">
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
                                        <div class="single-blog-content-head">
                                            <div class="line"></div>

                                            <!--la admin moi hien chuc nang sua,xoa-->
                                            <c:if test="${sessionScope.account.getRoleID() == 1}"> 
                                                <div class="single-blog-content-head-items">
                                                    <a><a href="update?updateId=${x.getPostID()}">
                                                            <i class="fas fa-edit"></i>
                                                        </a>
                                                        <a><a href="delete?deleteId=${x.getPostID()}">
                                                                <i class="fa fa-trash"></i>
                                                            </a>
                                                            </div>
                                                        </c:if>    
                                                        </div>

                                                        <h4><a href="post?postId=${x.getPostID()}" class="post-headline">${x.getStatus()}</a></h4>
                                                        <span class="post-previewContent">${x.getContent()}</span>
                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>
                                                    </c:forEach>

                                                    <!--phan trang-->
                                                    <div>
                                                        <form action="home" method="post">
                                                            <c:if test="${cp.cp!=0}">
                                                                <input class="btn_page" type="submit" name="home" value="Home"/>
                                                                <input class="btn_page" type="submit" name="pre" value="Pre"/>
                                                            </c:if>

                                                            <c:forEach begin="${cp.pageStart}" end="${cp.pageEnd}" var="i">
                                                                <span><input class="btn_page" type="submit" name="btn${i}" value="${i+1}"/></span>
                                                                </c:forEach>

                                                            <c:if test="${cp.cp!=cp.np-1}">
                                                                <input class="btn_page" type="submit" name="next" value="Next"/>
                                                                <input class="btn_page" type="submit" name="end" value="End"/>
                                                            </c:if>
                                                            <input type="text" hidden name="cp" value="${cp.cp}"/>
                                                            <input type="text" hidden name="np" value="${cp.np}"/>
                                                            <select name="nrpp">
                                                                <c:forEach items="${cp.arrNrpp}" var="i" varStatus="loop">
                                                                    <option value="${loop.index}"
                                                                            <c:if test="${loop.index==sessionScope.nrpp}">
                                                                                selected
                                                                            </c:if>
                                                                            >${i}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </form>
                                                    </div>
                                                </c:if>
                                                </div>

                                                <!--##### Sidebar Area #####--> 
                                                <div class="col-12 col-md-4 col-lg-3">
                                                    <div class="post-sidebar-area">

                                                        <div class="sidebar-widget-area">
                                                            <form action="search" class="search-form">
                                                                <input type="search" name="search" id="searchForm" placeholder="Search">
                                                                <input type="submit" value="search">
                                                            </form>

                                                        </div>

                                                        <div class="sidebar-widget-area">
                                                            <h5 class="title">Advertisement</h5>
                                                            <a href="#"><img src="../img/core-img/2.jpg" alt=""></a>
                                                        </div>
                                                    </div>
                                                </div>
                                                </div>
                                                </div>
                                                </div>
                                                <!--##### Blog Wrapper End #####--> 
                                                <%@include file="template/footer.jsp" %>
