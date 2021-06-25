<%--
  Created by IntelliJ IDEA.
  User: jmh
  Date: 2021/6/20
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user register</title>
  <link rel="stylesheet" href="css/register.css">
  <script type="text/javascript" src="js/register.js" ></script>
</head>
<body>
<div id="title">用户注册</div>

<div class="form">
  <form method="post" id="form" enctype="multipart/form-data" ACTION="/register_p" >
    <label>用 &nbsp户 &nbsp名</label>
    <input type="text" name="username" id="username" placeholder="请输入用户名"><br>
    <label>密 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码</label>
    <input type="password" name="password" id="password" placeholder="请输入密码"><br>
    <label>确认密码</label>
    <input type="password" name="pswagin" id="passwordagain" placeholder="请确认密码"><br>
    <label style="margin-right: 15;">选择文件</label>
    <input type="file" name="picture"><br>
    <input type="button" onclick="check()" value="注册"></input>
    <div id="tip"> </div>
  </form>
</div>
<div id="logo"><img src="image/logo.png" alt="logo" height="200px" > </div>

</body>
</html>
