<%@ page import="entity.User" %>
<%@ page import="entity.Feedback" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 4/8/2019
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Feedback> feedbacks = (ArrayList<Feedback>)request.getAttribute("feedbacks");
    if (feedbacks == null) {
        feedbacks = new ArrayList<>();
    }
    User user = (User) request.getAttribute("userLogged");
%>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="ADMIN"></jsp:param>
</jsp:include>
<body class="text-center">
<jsp:include page="fragment/header.jsp">
    <jsp:param name="userRole" value="<%=user.getRole()%>"></jsp:param>
</jsp:include>
<div class="feedback">
    <h1 class="h3 mb-3 font-weight-normal h1-custom">List feedback</h1>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Content</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <%if (feedbacks.size() > 0) {%>
            <%for (Feedback f: feedbacks) {%>
                <tr>
                    <th scope="row">1</th>
                    <td><%=f.getTitle()%></td>
                    <td><%=f.getContent()%></td>
                    <td class="text-warning">Processing</td>
                    <td>
                        <button onclick="accept(<%=f.getId()%>)" type="button" class="btn btn-success btn-sm">Accept</button>
                        <button onclick="reject(<%=f.getId()%>)" type="button" class="btn btn-danger btn-sm">Delete</button>
                    </td>
                </tr>
            <%}%>
        <%}%>

        </tbody>
    </table>
</div>
<script>
    function accept(id) {

    }

    function reject(id) {

    }
</script>
</body>
</html>
