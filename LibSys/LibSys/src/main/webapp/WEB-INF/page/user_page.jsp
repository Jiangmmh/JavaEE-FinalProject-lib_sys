<%--
  Created by IntelliJ IDEA.
  User: jmh
  Date: 2021/6/20
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>serch book</title>
    <link rel="stylesheet" href="css/user_search.css">
    <link rel="stylesheet" href="css/navigator.css">
<%--    <script type="text/javascript" src="js/login.js" ></script>--%>
</head>
<body>
<%
    if (session.getAttribute("userName") == null || !session.getAttribute("identity").equals("user"))
        request.getRequestDispatcher("/logout").forward(request, response);
%>
<div class="navigator">
    <ul>
        <li><a href="/home_page" class="active" style="color: aliceblue;">主页</a></li>
        <li><a href="/user_page">馆藏查询</a></li>
        <li><a href="/borrow_info">当前借阅</a></li>
        <li><a href="/personal_info">个人信息</a></li>
        <li style="float: right;"><a href="/logout" class="logout">注销</a></li>
    </ul>
</div>


<p class="font">馆藏查询</p><br>

<form action="/bk_search" class="user-search-box" id="form">
    <select name="type" id="type">
        <option value="byName">按书名</option>
        <option value="byAuthor">按作者</option>
        <option value="byType">按类型</option>
    </select>
    <input type="text" def id="search-input" placeholder="请输入搜索内容" name="content">
</form>

<img src="image/logo.png" alt="logo" class="logo" height="150">


</body>
</html>
