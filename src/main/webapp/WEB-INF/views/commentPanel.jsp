<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/11/15
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="panel panel-info col-md-offset-1" style="clear: both">

    <div class="panel-body">

        Commented by <a href="/FacebookSpringJpa/profile/${comment.user.id}">${comment.user.username}</a>
        on ${comment.created}
        <c:if test="${comment.user.id == user.id}">

            <form action="/FacebookSpringJpa/comments/remove" method="post" onsubmit="return confirmAction()">
                <input type="hidden" name="commentId" value="${comment.id}"/>
                <button type="submit" name="removeCommentSubmit" class="glyphicon glyphicon-trash btn pull-right"
                        style="margin-top:-26px;background: transparent;"></button>
            </form>


            <%-- <a onclick="return confirmAction()" href="/FacebookSpring/removeComment/${comment.id}"><span
                     class="glyphicon glyphicon-trash pull-right"></span></a>--%>
        </c:if>
        <p><c:out value="${comment.content}"/></p>
    </div>

</div>


