<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/10/15
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>

<div class="container">

    <div class="row">

        <div class="col-md-6 col-md-offset-3">

            <c:if test="${!empty success}">
                <div class="alert alert-success" role="alert">ACCOUNT SIGNUP SUCCESSFULL.</div>
            </c:if>

            <c:if test="${!empty error}">
                <c:if test="${error eq 1}">
                    <div class="alert alert-danger" role="alert">
                        ACCOUNT SIGNUP FAILED.
                        <sf:errors></sf:errors>
                    </div>
                </c:if>
            </c:if>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Signup</h3>
                </div>
                <div class="panel-body">

                    <sf:form action="/FacebookSpringJpa/signup" method="POST" commandName="signupUser" enctype="multipart/form-data">

                        <sf:errors path="username"/><br>
                        <input id="username" name="username" class="form-control" placeholder="Username" type="text"
                               required/> <br>

                        <sf:errors path="firstName"/><br>
                        <input id="firstName" name="firstName" class="form-control" placeholder="Firstname" type="text"
                               required/> <br>

                        <sf:errors path="lastName"/><br>
                        <input id="lastName" name="lastName" class="form-control" placeholder="Lastname" type="text"
                               required/><br>

                        <sf:errors path="DOB"/><br>
                        <input id="DOB" name="DOB" class="form-control" placeholder="Date Of Birth" type="text"
                               onfocus="this.type='date'" onblur="this.type='text'" required/><br>

                        <sf:errors path="email"/><br>
                        <input id="email" name="email" class="form-control" placeholder="Email" type="text"
                               required/><br>

                        <sf:errors path="password"/><br>
                        <input id="password" name="password" class="form-control" placeholder="Password" type="password"
                               required/><br>

                        <p>Profile Photo</p>
                        <input type="file" name="picture"/><br>

                        <input type="submit" class="btn btn-default form-control" name="register"
                               value="Signup"/><br><br>
                        <a href="login" class="btn btn-default form-control">Login</a><br><br>

                    </sf:form>

                    <%-- <form name="signup" action="" method="POST" enctype="multipart/form-data">

                         <input type="text" name="username" class="form-control" placeholder="Username" required/> <br>
                         <input type="text" name="firstname" class="form-control" placeholder="Firstname" required/> <br>
                         <input type="text" name="lastname" class="form-control" placeholder="Lastname" required/><br>
                         <input type="text" class="form-control" name="dob" placeholder="Date Of Birth"
                                onfocus="this.type='date'"
                                onblur="this.type='text'" required/><br>
                         <input type="email" name="email" class="form-control" placeholder="Email" required/><br>
                         <input type="password" name="password" class="form-control" placeholder="Password"
                                required/><br>
                         <input type="file" name="profilePicture" /><br>
                         <input type="submit" class="btn btn-default form-control" name="register"
                                value="Signup"/><br><br>
                         <a href="login" class="btn btn-default form-control">Login</a><br><br>

                     </form>--%>

                </div>
            </div>


        </div>

    </div>


    <%@include file="footer.jsp" %>
