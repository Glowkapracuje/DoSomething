<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 16.07.19
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="concert">
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
        Zespol: <form:input path="band"/>
        <form:errors path="band"/>
<%--        Organizator: <form:input path="organizer.name"/>--%>
<%--        <form:errors path="organizer.name"/>--%>
        <input name="typeOfEvent" type="hidden" value="concert"/>
        <input type="submit">
    </form:form>
</body>
</html>

<%--@Id--%>
<%--@GeneratedValue(strategy = GenerationType.IDENTITY)--%>
<%--private Long id;--%>

<%--@NotBlank--%>
<%--private String name;--%>

<%--@Temporal(TemporalType.DATE)--%>
<%--@DateTimeFormat(pattern = "yyyy-MM-dd")--%>
<%--private Date date;--%>

<%--@NotBlank--%>
<%--private String place;--%>

<%--@Column(name="howManyGuests")--%>
<%--private Integer howManyGuests;--%>

<%--@ManyToOne--%>
<%--private Organizer organizer;--%>

<%--@ManyToMany--%>
<%--private List<Participant> participantList;--%>

<%--private String description;--%>

<%--@NotBlank--%>
<%--private String typeOfEvent;--%>