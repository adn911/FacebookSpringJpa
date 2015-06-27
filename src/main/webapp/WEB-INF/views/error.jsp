<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 4/12/15
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp" %>

<c:if test="${not empty errCode}">
    <h1>${errCode} : System Errors</h1>
</c:if>

<c:if test="${not empty errMsg}">
    <h2>${errMsg}</h2>
</c:if>

<%@include file="footer.jsp" %>