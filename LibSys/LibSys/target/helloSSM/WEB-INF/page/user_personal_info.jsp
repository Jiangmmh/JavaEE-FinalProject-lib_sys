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
    <title>用户信息</title>
    <link rel="stylesheet" href="css/navigator.css">
    <link rel="stylesheet" href="css/user_info.css">
    <script type="text/javascript" src="js/user_info.js"></script>
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


<p class="font">个人信息</p><br>

<div class="form" style="height: 330;">
    <form action="/modify_password" id="form">
        <img src="image/${userName}.jpg" height="50" alt="sponge" class="prof"><br>
        <label>用 &nbsp户 名</label>
        <input name="username" type="text" onclick="disappear()" readonly="readonly" value="${userName}"><br>
        <label>新 &nbsp密 码</label>
        <input name="psw" type="password" onclick="disappear()" id="psw"><br>
        <label>确认密码</label>
        <input name="pswagain" type="password"  id="pswagain"><br>
        <input type="button" onclick="check()" value="提交">
        <p id="tip"> 123</p>
    </form>
</div>

</body>
</html>
