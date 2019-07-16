<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 15.07.19
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to DoSomething</title>
</head>
<body>
<c:choose>
    <c:when test="${empty email}">
        <h2>
            <button onclick="javascript:document.location.href='login/organizer/register'">Zarejestruj organizatora.</button><br>
            <button onclick="javascript:document.location.href='login/organizer/login'">Zaloguj sie jako organizator.</button><br>
            <button onclick="javascript:document.location.href='login/participant/register'">Zarejestruj uczestnika.</button><br>
            <button onclick="javascript:document.location.href='login/participant/login'">Zaloguj sie jako uczestnik.</button><br>
        </h2>
    </c:when>
    <c:otherwise>
        <button onclick="javascript:document.location.href='/logout'">Wyloguj sie.</button>
    </c:otherwise>
</c:choose>
</body>
</html>
