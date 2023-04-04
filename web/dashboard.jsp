<%@include file="template/header.jsp" %>
<div>
    <form method="post">
        FromDate:<input type="date" name="fromDate"><br>
        ToDate:<input type="date" name="toDate"> <br>
        <input type="submit" value="Submit">
    </form>
    <c:if test="${maxPost!=null}">
    Total post from ${fDate} to ${tDate}: ${Tpost}<br/>
    Total Comment on posts from ${fDate} to ${tDate}: ${Tcomment}<br/>
    Posts with the most comments: <br/> <br> <br>
    <c:if test="${Tcomment == 0}">
        <h2>There is has no post has max comment</h2>
    </c:if>
    <c:forEach items="${maxPost}" var="x" >
        <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.2s" data-wow-duration="1000ms">
        <div class="row align-items-center">
            <div class="col-12 col-md-6">
                <div class="single-blog-thumbnail">
                    <img src="postimg/${x.getImage()}" alt="">
                </div>
            </div>
            <div class="col-12 col-md-6">
                <div class="single-blog-content">
                    <div class="single-blog-content-head">
                        <div class="line"></div>
                            </div>
                            <h4><a href="post?postId=${x.getPostID()}" class="post-headline">${x.getStatus()}</a></h4>
                        <span class="post-previewContent">${x.getContent()}</span>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>    
    </c:if>
    </div>
    
<%@include file="template/footer.jsp" %>