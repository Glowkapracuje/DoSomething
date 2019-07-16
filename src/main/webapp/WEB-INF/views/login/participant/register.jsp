<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 16.07.19
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="participant" method="post">
    Imie: <form:input path="firstName"/>
    <form:errors path="firstName"/><br>

    Nazwisko: <form:input path="lastName"/>
    <form:errors path="lastName"/><br>

    Email: <form:input path="email"/>
    <form:errors path="email"/><br>

    Password: <form:password path="password"/>
    <form:errors path="password"/><br>

    Confirm password: <input type="password" name="confirmPassword"/><br>

    <input type="submit" value="Register">

</form:form>
</body>
</html>
