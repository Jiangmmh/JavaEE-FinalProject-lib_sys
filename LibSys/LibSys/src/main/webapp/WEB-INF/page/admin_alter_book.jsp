<%--
  Created by IntelliJ IDEA.
  User: jmh
  Date: 2021/6/20
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("userName") == null || !session.getAttribute("identity").equals("admin"))
        request.getRequestDispatcher("/logout").forward(request, response);
%>

<html>
<head>
    <title>book_alter</title>
    <link rel="stylesheet" href="css/navigator.css">
    <link rel="stylesheet" href="css/form.css">
    <script type="text/javascript" src="js/alter_book.js" ></script>
</head>



<body>

<div class="navigator">
    <ul>
        <li><a href="/home_page" class="active" style="color: aliceblue;">主页</a></li>
        <li><a href="/book_manage">图书管理</a></li>
        <li><a href="/type_manage">类别管理</a></li>
        <li><a href="/user_manage">用户管理</a></li>
        <li style="float: right;"><a href="/logout" class="logout">注销</a></li>
    </ul>
</div>

<p class="font">更新图书信息</p><br>

<div class="form">
    <form method="get" action="/update_book" id="form">
        <label>序 &nbsp&nbsp号</label>
        <input name="bookId" type="text" value="${book.getBookId()}" onclick="disappear()" readonly="readonly"> <br>
        <label>书 &nbsp&nbsp名</label>
        <input name="bookName" id="name" type="text" onclick="disappear()"  value="${book.getBookName() }" > <br>
        <label>作 &nbsp&nbsp者</label>
        <input name="author" id="author" type="text" onclick="disappear()" value="${book.getAuthor()}"> <br>
        <label>总 &nbsp&nbsp数</label>
        <input name="totalQuantity" id="total" type="number" onclick="disappear()" value="${book.getTotalQuantity()}"> <br>
        <label>在馆数</label>
        <input name="remQuantity" id="rem" type="number" onclick="disappear()" value="${book.getRemQuantity()}"><br>
        <label>类 &nbsp&nbsp别</label>
        <select name="type" id="type"  onclick="disappear()" >
            <c:forEach var="type" items="${types}">
                <tr>
                    <option value="${type.getType()}">${type.getType()}</option>
                </tr>
            </c:forEach>
        </select>

        <div>
            <input type="button" onclick="check()" value="更新"></input>
        </div>

        <div id="tip">
            123
        </div>
    </form>
</div>

</body>
</html>
