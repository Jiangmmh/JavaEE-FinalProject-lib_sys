<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>type_manage</title>
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/navigator.css">
</head>

<style>
    a.add {
        float: left;
        margin-left: 10;
        margin-top: 17;
        margin-bottom: 10;
        color: rgb(0, 140, 180);
        text-decoration: none;
        font-size: 18;
        /* border-style:double; */
    }

    a.add:hover {
        background-color: rgb(0, 200, 200);
        color: aliceblue;
    }
</style>

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

<p class="font">类别管理</p><br>

<a href="/to_add_type" class="add">添加类型</a>
<table border="1" id="table">
    <tr>
        <th>序号</th>
        <th>类型</th>
        <th>数量</th>
        <th colspan="2">操作</th>
    </tr>

    <c:forEach var="type" items="${types}">
        <tr>
            <td>${type.getId()}</td>
            <td>${type.getType()}</td>
            <td>${type.getQuantity()}</td>
            <td><a href="/to_alter_type?typeId=${type.getId()}">修改</a></td>
            <td><a href="/delete_type?typeId=${type.getId()}">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
