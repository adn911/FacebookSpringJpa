<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/12/15
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>

<div class="col-md-6 col-md-offset-3">
    <c:if test="${!empty param.success}">
        <div class="alert alert-success" role="alert">NEW FRIEND ADDED SUCCESSFULLY .</div>
    </c:if>

    <%@include file="addableFriendsListPanel.jsp" %>
</div>

<%@include file="footer.jsp" %>