<%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 4/8/2019
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="REGISTER"></jsp:param>
</jsp:include>
<body class="text-center">
<form class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">Please register</h1>
    <label for="inputUsername" class="sr-only">Username</label>
    <input type="text" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <label for="inputFullName" class="sr-only">FullName</label>
    <input type="text" id="inputFullName" class="form-control" placeholder="FullName" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
</form>

<jsp:include page="fragment/script-bootstrap.jsp"></jsp:include>
</body>
</html>
