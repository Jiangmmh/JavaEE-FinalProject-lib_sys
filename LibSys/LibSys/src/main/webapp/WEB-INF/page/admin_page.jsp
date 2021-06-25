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
  <title>book_manage</title>
  <link rel="stylesheet" href="css/table.css">
  <link rel="stylesheet" href="css/navigator.css">
  <link rel="stylesheet" href="css/search.css">
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

<p class="font">图书管理</p><br>


<a href="/add_page" class="add">添加书籍</a>

<form action="/bk_search" class="search-box">
  <input type="text" placeholder="请输入搜索内容" name="content">
  <select name="type" id="type">
    <option value="byName">按书名</option>
    <option value="byAuthor">按作者</option>
    <option value="byType">按类型</option>
  </select>
  <input type="submit" value="搜索">
</form>

<table  id="table">
  <tr>
    <th>书籍名称</th>
    <th>作者</th>
    <th>类型</th>
    <th>总数</th>
    <th>在馆数</th>
    <th colspan="2">操作</th>
  </tr>

  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.getBookName()}</td>
      <td>${book.getAuthor()}</td>
      <td>${book.getType()}</td>
      <td>${book.getTotalQuantity()}</td>
      <td>${book.getRemQuantity()}</td>
      <td><a href="/alter_book?bookName=${book.getBookName()}">修改</a></td>
      <td><a href="/delete_book?bookName=${book.getBookName()}">删除</a></td>
    </tr>
  </c:forEach>

</table>


</body>
</html>
