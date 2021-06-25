<%--
  Created by IntelliJ IDEA.
  User: jmh
  Date: 2021/6/20
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user_manage</title>
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/navigator.css">
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

<p class="font">用户管理</p><br>

<table border="1" id="table">
    <tr>
        <th>用户名</th>
        <th>借阅数量</th>
<%--        <th>逾期数量</th>--%>
        <th>累计罚款</th>
        <th colspan="2">操作</th>
    </tr>

    <c:forEach var="userInfo" items="${userInfos}">
        <tr>
            <td>${userInfo.getUserName()}</td>
            <td>${userInfo.getBorrowQuantity()}</td>
<%--            <td>${userInfo.getOverDueQuantity()}</td>--%>
            <td>${userInfo.getFine()}</td>
            <td><a href="/reset_user_password?userName=${userInfo.getUserName()}">重置密码</a></td>
            <td><a href="/delete_user?userName=${userInfo.getUserName()}">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
