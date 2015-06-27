<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/11/15
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="col-md-6 col-md-offset-3">

    <div class="panel panel-info">
        <%-- <div class="panel-heading">Post Status</div>--%>
        <div class="panel-body">
            <form action="/FacebookSpringJpa/posts/add" method="POST">
                <textarea class="form-control" rows="2" name="postContent" placeholder="Post Status.."
                          required></textarea>
                <input class="btn btn-default pull-right" type="submit" name="postSubmit" value="post">
            </form>
        </div>
    </div>

    <hr class="divider">
</div>