<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 4/8/2019
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%String role = (String) request.getParameter("userRole");%>
<header>
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
        <a class="navbar-brand" href="/home">Tom & Jerry</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/feedback">Feedback</a>
                </li>
                <%if ("2".equals(role)) {%>
                    <li class="nav-item">
                        <a class="nav-link" href="/admin">Admin</a>
                    </li>
                <%}%>
            </ul>
        </div>
    </nav>
</header>

