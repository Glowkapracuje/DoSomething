<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>Register</h2>
<div>
    <form:form modelAttribute="organizer" method="post">
        Imie: <form:input path="name"/>
        <form:errors path="name"/><br>

        Nazwisko: <form:input path="surname"/>
        <form:errors path="surname"/><br>

        Email: <form:input path="email"/>
        <form:errors path="email"/><br>

        Password: <form:password path="password"/>
        <form:errors path="password"/><br>

        Confirm password: <input type="password" name="confirmPassword"/><br>

        <input type="submit" value="Register">

    </form:form>
</div>
</body>
</html>
