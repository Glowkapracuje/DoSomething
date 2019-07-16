<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 15.07.19
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Login</h2>
<c:if test="${success == false}">
    <p>Login failed. Email or password is incorrect.</p>
</c:if>
<form action="/login/organizer/login" method="post">
    Email: <input type="email" name="email" required/><br>
    Password: <input type="password" name="password" required/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
