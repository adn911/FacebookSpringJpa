<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/9/15
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>

<div class="container">

    <div class="row">
        <%@include file="postInputBox.jsp" %>
    </div>

    <div class="row">

        <div class="col-md-6 col-md-offset-3">

            <c:if test="${!empty posts}">

                <c:forEach items="${posts}" var="post">

                    <%@include file="postPanel.jsp" %>

                    <c:forEach items="${post.comments}" var="comment">
                        <%@include file="commentPanel.jsp" %>
                    </c:forEach>

                    <%@include file="commentInputBox.jsp" %>

                    <hr class="divider">

                </c:forEach>

            </c:if>

        </div>

    </div>

</div>

<%@include file="footer.jsp" %>