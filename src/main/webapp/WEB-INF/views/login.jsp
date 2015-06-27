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

        <div class="col-md-4 col-md-offset-4">

            <c:if test="${!empty error}">
                <div class="alert alert-danger" role="alert">${error}.</div>
            </c:if>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Login</h3>
                </div>
                <div class="panel-body">

                    <form name="/FacebookSpringJpa/login" action="" method="POST">

                        <input type="email" name="email" class="form-control" placeholder="Email" required/><br>
                        <input type="password" name="password" class="form-control" placeholder="password"
                               required/><br>
                        <input type="submit" class="btn btn-default form-control" name="login" value="login"/><br><br>
                        <a href="/FacebookSpringJpa/signup" class="btn btn-default form-control">Signup</a><br><br>

                    </form>
                </div>
            </div>


        </div>


    </div>

</div>


<%@include file="footer.jsp" %>
