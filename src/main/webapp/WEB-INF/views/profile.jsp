<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/10/15
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>

<div class="container">
    <%--
        <div class="row">
            <%@include file="postInputBox.jsp" %>
        </div>--%>

    <div class="row">

        <div class="col-md-2 col-md-offset-1">

            <div>

                <img class="img-circle" src="/FacebookSpringJpa/resources/uploads/photoes/${user.profilePicture}"
                     class="img-thumbnail"
                     width="100px" height="100px" alt="${user.profilePicture}"><br><br>

            </div>

        </div>

        <div class="col-md-6">


            <c:if test="${!empty posts}">

                <c:forEach items="${posts}" var="post">
                    <%@include file="postPanel.jsp" %>
                    <c:forEach items="${post.comments}" var="comment">
                        <%@include file="commentPanel.jsp" %>
                    </c:forEach>
                </c:forEach>

            </c:if>

        </div>

    </div>

</div>

<%@include file="footer.jsp" %>
