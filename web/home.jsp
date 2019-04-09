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
%>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="HOME"></jsp:param>
</jsp:include>
<body class="text-center">
<jsp:include page="fragment/header.jsp"></jsp:include>
<div class="feedback">
    <h1 class="h3 mb-3 font-weight-normal h1-custom">List feedback</h1>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Content</th>
        </tr>
        </thead>
        <tbody>
        <%if (feedbacks.size() > 0) {%>
            <%for (Feedback feedback: feedbacks) {%>
                <tr>
                    <th><%=feedback.getId()%></th>
                    <td><%=feedback.getTitle()%></td>
                    <td><%=feedback.getContent()%></td>
                </tr>
            <%}%>
        <%}%>
        </tbody>
    </table>
</div>

</body>
</html>
