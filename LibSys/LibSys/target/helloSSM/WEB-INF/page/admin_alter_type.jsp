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
    <title>book_alter</title>
    <link rel="stylesheet" href="css/navigator.css">
    <link rel="stylesheet" href="css/form.css">
    <script type="text/javascript" src="js/alter_class.js"></script>
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

<p class="font">更新类别</p><br>

<div class="form" style="height: 200;">
    <form method="get" action="/update_type" id="form">
        <label>序 &nbsp&nbsp号</label>
        <input name="typeId" type="text" onclick="disappear()" value="${bookType.getId()}" style="margin-top: 10px; margin-bottom: 8px;" readonly="readonly"> <br>
        <label>类型名</label>
        <input name="type" type="text" onclick="disappear()" value="${bookType.getType()}" id="type" style="margin-top: 10px; margin-bottom: 4px;"> <br>
        <br>
        <input type="button" onclick="check()" value="更新"> </input>

        <div id="tip">
            123
        </div>
    </form>
</div>

</body>
</html>
