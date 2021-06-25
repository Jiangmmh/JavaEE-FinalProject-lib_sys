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
    <title>add_book</title>
    <link rel="stylesheet" href="css/navigator.css">
    <link rel="stylesheet" href="css/form.css">
    <script type="text/javascript" src="js/add_book.js"></script>
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

<p class="font">添加图书</p><br>

<div class="form" style="height: 300;">
    <form method="get" action="/add_book" id="form">
        书名: <input name="bookName" id="name" onclick="disappear()" style="margin-top: 25px; margin-bottom: 8px;" type="text"> <br>
        作者: <input name="author" id="author" onclick="disappear()" style="margin-top: 10px; margin-bottom: 8px;" type="text"> <br>
        数量: <input name="quantity" id="quantity" onclick="disappear()" style="margin-top: 10px; margin-bottom: 8px;" type="number"> <br>
        类别:
        <select name="type" onclick="disappear()" id="type" style="margin-top: 10px; margin-bottom: 8px;">
            <c:forEach var="type" items="${types}">
                <tr>
                    <option value="${type.getType()}">${type.getType()}</option>
                </tr>
            </c:forEach>
        </select>
        <br>
        <input type="button" onclick="check()" value="添加"></input>

        <div id="tip">
            123
        </div>
    </form>
</div>

</body>
</html>
