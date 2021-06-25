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
  <link rel="stylesheet" href="css/navigator.css">
  <link rel="stylesheet" href="css/table.css">
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

<table border="1" id="table">
  <tr>
    <th>书籍名称</th>
    <th>作者</th>
    <th>类型</th>
    <th>总数</th>
    <th>在馆数</th>
    <th></th>
  </tr>

  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.getBookName()}</td>
      <td>${book.getAuthor()}</td>
      <td>${book.getType()}</td>
      <td>${book.getTotalQuantity()}</td>
      <td>${book.getRemQuantity()}</td>
      <td><a href="/borrow?bookName=${book.getBookName()}">借阅</a></td>
    </tr>
  </c:forEach>

</table>

</body>
</html>
