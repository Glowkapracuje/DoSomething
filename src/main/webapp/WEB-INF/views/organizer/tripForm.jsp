<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 16.07.19
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="trip">
    Nazwa: <form:input path="name"/>
    <form:errors path="name"/>
    Data: <form:input path="date"/>
    <form:errors path="date"/>
    Miejsce: <form:input path="place"/>
    <form:errors path="place"/>
    Ilu gosci: <form:input path="howManyGuests"/>
    <form:errors path="howManyGuests"/>
    Opis: <form:input path="description"/>
    <form:errors path="description"/>
    Skad: <form:input path="fromWhere"/>
    <form:errors path="fromWhere"/>
    Dokad: <form:input path="toWhere"/>
    <form:errors path="toWhere"/>
    Ekwipunek: <form:input path="equipmentDescription"/>
    <form:errors path="equipmentDescription"/>
    <%--        Organizator: <form:input path="organizer.name"/>--%>
    <%--        <form:errors path="organizer.name"/>--%>
    Wycieczka: <form:input path="typeOfEvent"/>
    <form:errors path="typeOfEvent"/>
    <input type="submit">
</form:form>
</body>
</html>
