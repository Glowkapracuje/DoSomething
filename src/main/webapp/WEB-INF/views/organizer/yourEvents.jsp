<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 16.07.19
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${events}" var="event">
        <c:out value="${event.name}"/><br>
        <c:out value="${event.date}"/><br>
        <c:out value="${event.description}"/><br>
        <button onclick="document.location.href='/organizers/edit/${event.id}'">Edytuj</button>
        <button onclick="">Usun</button><br>
        <br>
    </c:forEach>
</body>
</html>
