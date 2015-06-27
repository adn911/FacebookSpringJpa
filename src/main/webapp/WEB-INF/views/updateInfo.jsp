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
                <div class="alert alert-success" role="alert">INFO UPDATED SUCCESSFULLY.</div>
            </c:if>

            <c:if test="${!empty error}">
                <c:if test="${error eq 1}">
                    <div class="alert alert-danger" role="alert">INFO UPDATE FAILED.</div>
                </c:if>
            </c:if>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Update Info</h3>
                </div>
                <div class="panel-body">

                    <sf:form name="updateInfo" action="" method="POST" commandName="userInfo" enctype="multipart/form-data">
                        <input type="hidden" id="id" name="id" class="form-control" value="${userInfo.id}"/>
                        <label>Username </label> <br>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Username"
                               value="${userInfo.username}" required/> <br>
                        <label>First Name </label> <br>
                        <input type="text" id="firstName" name="firstName" class="form-control" placeholder="Firstname"
                               value="${userInfo.firstName}" required/> <br>
                        <label>Last Name </label> <br>
                        <input type="text" name="lastName" name="lastName" class="form-control" placeholder="Lastname"
                               value="${userInfo.lastName}" required/><br>
                        <label>Date Of Birth </label> <br>
                        <input type="text" id="DOB" name="DOB" class="form-control" placeholder="Date Of Birth"
                               onfocus="this.type='date'"
                               onblur="this.type='text'" value="${userInfo.DOB}" required/><br>
                        <label>Email </label> <br>
                        <input type="text" id="email" name="email" class="form-control" placeholder="Email"
                               value="${userInfo.email}"
                               required/><br>
                        <label>Password </label> <br>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                               value="${userInfo.password}"
                               required/><br>

                        <label>Profile Photo</label> <br>
                        <input type="file" name="picture"/><br>

                        <input type="submit" class="btn btn-default form-control" name="updateInfoSubmit"
                               value="update"/><br><br>

                    </sf:form>

                </div>
            </div>


        </div>

    </div>


    <%@include file="footer.jsp" %>
