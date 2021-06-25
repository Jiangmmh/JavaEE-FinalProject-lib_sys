<%--
  Created by IntelliJ IDEA.
  User: jmh
  Date: 2021/6/20
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>serch book</title>
</head>
<body>
<%
    if (session.getAttribute("user") == null)
        request.getRequestDispatcher("login.jsp").forward(request, response);
%>
<p>Search Page</p>

<a href="/logout">注销</a>
</body>
</html>
