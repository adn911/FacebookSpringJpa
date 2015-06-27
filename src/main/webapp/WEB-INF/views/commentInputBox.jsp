<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/11/15
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>


<div class="panel panel-info col-md-offset-1">
    <div class="panel-body">
        <%-- Add a comment<br>--%>
        <form action="/FacebookSpringJpa/comments/add" method="POST">
            <input type="hidden" name="postId" value="${post.id}"/>
            <textarea class="form-control" rows="1" name="commentContent" placeholder="Add Comment.."
                      required></textarea>
            <input class="btn btn-default pull-right" type="submit" name="commentSubmit" value="comment">
        </form>
    </div>
</div>
