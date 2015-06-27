<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/11/15
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="panel panel-info" style="clear: both">

    <div class="panel-heading">
        Posted by <a href="/FacebookSpringJpa/profile/${post.user.id}">${post.user.username}</a>
        at ${post.created}
        ${post.user.id}
        <c:if test="${post.user.id == user.id}">

            <form action="/FacebookSpringJpa/posts/remove" method="post" onsubmit="return confirmAction()">
                <input type="hidden" name="postId" value="${post.id}"/>
                <button type="submit" class="glyphicon glyphicon-trash btn pull-right"
                        style="margin-top:-26px;background: transparent;" name="removePostSubmit"></button>
            </form>

            <%--   <a onclick="return confirmAction()" href="/FacebookSpring/removePost/${post.id}"><span
                       class="glyphicon glyphicon-trash pull-right"></span></a>--%>
        </c:if>
    </div>
    <div class="panel-body">
        <p><c:out value="${post.content}"/></p>
        <span>${fn:length(post.likes)}
        <form action="/FacebookSpringJpa/likes/add" method="post" >
            <input type="hidden" name="postId" value="${post.id}"/>
            <button type="submit" class="glyphicon glyphicon-thumbs-up btn pull-left"
                    style="margin-top:-26px;background: transparent;" name="addLikeSubmit"></button>
        </form>
            </span>
    </div>

</div>


