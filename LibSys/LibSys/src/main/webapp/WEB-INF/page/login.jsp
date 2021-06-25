<%--
  Created by IntelliJ IDEA.
  User: jmh
  Date: 2021/6/20
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/login.js" ></script>
</head>

<body>
<div id="title"><spring:message code="login.title" text="default text"/></div>

<div class="form">
    <form method="post" ACTION="/login_p" id="loginForm">
        <label><spring:message code="login.username" text="default text"/></label>
        <input type="text" id="name" name="username" placeholder="<spring:message code="login.tip_user_name" text="default text"/>" onclick="disappear()" oninput=""><br>
<%--        <label>密&nbsp&nbsp 码</label>--%>
        <label><spring:message code="login.password" text="default text"/></label>
        <input type="password"  id="psw"class="input_frame" name="password" placeholder="<spring:message code="login.tip_password" text="default text"/>" onclick="disappear()"><br>
        <div>
            <input type="button" onclick="login()" value="<spring:message code="login.bntlogin" text="default text"/>"></input>
            <input type="button" onclick="register()" value="<spring:message code="login.bntregister" text="default text"/>"></input>
        </div>
        <div id="tip">
            123
        </div>
    </form>
</div>

<div id="logo"><img src="image/logo.png" alt="logo" height="200px" > </div>
</body>

</html>
