<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Feedback" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 4/8/2019
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Feedback feedback = (Feedback) request.getAttribute("feedback");
    if (feedback == null) {
        feedback = new Feedback();
    }

    User user = (User) request.getAttribute("userLogged");
%>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="FEEDBACK"></jsp:param>
</jsp:include>
<body class="text-center">
<jsp:include page="fragment/header.jsp">
    <jsp:param name="userRole" value="<%=user.getRole()%>"></jsp:param>
</jsp:include>
<form class="form-signin" method="post" action="/feedback">
    <ul>
        <%if (errors.containsKey("title")) {%>
            <% for (String title: errors.get("title")) {%>
            <li><%=title%></li>
            <%}%>
        <%}%>
        <%if (errors.containsKey("content")) {%>
            <% for (String content: errors.get("content")) {%>
            <li><%=content%></li>
            <%}%>
        <%}%>
    </ul>
    <h1 class="h3 mb-3 font-weight-normal">Please feedback</h1>
    <label for="inputTitle" class="sr-only">Title</label>
    <input name="title" type="text" id="inputTitle" class="form-control" placeholder="Title" value="<%=feedback.getTitle()==null ? "" : feedback.getTitle()%>" required autofocus>
    <label for="inputContent" class="sr-only">Content</label>
    <textarea name="content" id="inputContent" class="form-control" placeholder="Content" aria-label="With textarea"></textarea>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

</form>

<jsp:include page="fragment/script-bootstrap.jsp"></jsp:include>
</body>
</html>
