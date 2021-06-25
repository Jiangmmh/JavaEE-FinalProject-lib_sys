<%--
  Created by IntelliJ IDEA.
  User: jmh
  Date: 2021/6/20
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>type_add</title>
    <link rel="stylesheet" href="css/navigator.css">
    <link rel="stylesheet" href="css/form.css">
    <script type="text/javascript" src="js/add_type.js"></script>
</head>
<body>
<%
    if (session.getAttribute("userName") == null || !session.getAttribute("identity").equals("admin"))
        request.getRequestDispatcher("/logout").forward(request, response);
%>

<div class="navigator">
    <ul>
        <li><a href="/home_page" class="active" style="color: aliceblue;">主页</a></li>
        <li><a href="/book_manage">图书管理</a></li>
        <li><a href="/type_manage">类别管理</a></li>
        <li><a href="/user_manage">用户管理</a></li>
        <li style="float: right;"><a href="/logout" class="logout">注销</a></li>
    </ul>
</div>

<p class="font">添加类别</p><br>

<div class="form" style="height: 150;">
    <form method="get" action="/add_type" id="form">
        <label>类别</label>
        <input name="type" id="type" type="text" onclick="disappear()" style="margin-top: 20;"> <br>
        <input type="button" onclick="check()" value="添加"></input>
        <div id="tip">
            123
        </div>
    </form>
</div>

</body>
</html>