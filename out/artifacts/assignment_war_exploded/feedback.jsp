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
    <jsp:param name="title" value="FEEDBACK"></jsp:param>
</jsp:include>
<body class="text-center">
<jsp:include page="fragment/header.jsp"></jsp:include>
<form class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">Please feedback</h1>
    <label for="inputTitle" class="sr-only">Title</label>
    <input type="text" id="inputTitle" class="form-control" placeholder="Title" required autofocus>
    <label for="inputContent" class="sr-only">Content</label>
    <textarea id="inputContent" class="form-control" placeholder="Content" aria-label="With textarea"></textarea>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

</form>

<jsp:include page="fragment/script-bootstrap.jsp"></jsp:include>
</body>
</html>
