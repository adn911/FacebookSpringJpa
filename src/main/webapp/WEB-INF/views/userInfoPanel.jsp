<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/11/15
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title text-center">Profile Info</h3>
    </div>
    <div class="panel-body">

        <table class="table table-bordered table-striped">

            <tr>
                <td>Username</td>
                <td>${user.username}</td>
            </tr>

            <tr>
                <td>FirstName</td>
                <td>${user.firstName}</td>
            </tr>

            <tr>
                <td>LastName</td>
                <td>${user.lastName}</td>
            </tr>

            <tr>
                <td>Date Of Birth</td>
                <td>${user.DOB}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.email}</td>
            </tr>

            <tr>
                <td></td>
                <td><a href="/FacebookSpringJpa/updateInfo" class="btn btn-default">Edit Info</a></td>
            </tr>
        </table>

    </div>
</div>


