<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 16.07.19
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div>
<c:forEach items="${events}" var="event">
    Nazwa: <c:out value="${event.name}"/><br>
    Data: <c:out value="${event.date}"/><br>
    Miejsce: <c:out value="${event.place}"/><br>
    <c:if test="${event.typeOfEvent=='concert'}">
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample1" role="button" aria-expanded="false" aria-controls="collapseExample">
            Szczegoly
        </a>
        <div class="collapse" id="collapseExample1">
            <div class="card card-body">
                Zespol: <c:out value="${event.band}"/><br>
                Opis: <c:out value="${event.description}"/><br>
                Organizator: <c:out value="${event.organizer.name}"/>

                <div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=${event.place}&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://www.bitgeeks.net/embed-google-map/">how can i see embed on google map</a></div><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style>
                </div>
            </div>
            </div>

        <button onclick="javascript:document.location.href='/participants/join'">Dolacz do wydarzenia</button>
    </c:if>
    <c:if test="${event.typeOfEvent=='dance'}">
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample2" role="button" aria-expanded="false" aria-controls="collapseExample">
            Szczegoly
        </a>

        <div class="collapse" id="collapseExample2">
            <div class="card card-body">
                Typ potancowki:<c:out value="${event.typeOfDance}"/><br>
                Ubior: <c:out value="${event.typeOfDress}"/><br>
                Opis: <c:out value="${event.description}"/><br>
                Organizator: <c:out value="${event.organizer.name}"/>

                <div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=${event.place}&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://www.bitgeeks.net/embed-google-map/">how can i see embed on google map</a></div><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style></div>
            </div>
        </div>

        <button onclick="javascript:document.location.href='/participants/join'">Dolacz do wydarzenia</button>
    </c:if>
    <c:if test="${event.typeOfEvent=='meeting'}">
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample3" role="button" aria-expanded="false" aria-controls="collapseExample">
            Szczegoly
        </a>
        <div class="collapse" id="collapseExample3">
            <div class="card card-body">
                Temat: <c:out value="${event.topic}"/><br>
                Opis: <c:out value="${event.description}"/><br>
                Organizator: <c:out value="${event.organizer.name}"/>

                <div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=${event.place}&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://www.bitgeeks.net/embed-google-map/">how can i see embed on google map</a></div><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style></div>
            </div>
            </div>

        <button onclick="javascript:document.location.href='/participants/join'">Dolacz do wydarzenia</button>
    </c:if>
    <c:if test="${event.typeOfEvent=='trip'}">
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample4" role="button" aria-expanded="false" aria-controls="collapseExample">
            Szczegoly
        </a>
        <div class="collapse" id="collapseExample4">
            <div class="card card-body">
                Skad: <c:out value="${event.fromWhere}"/><br>
                Dokad: <c:out value="${event.toWhere}"/><br>
                Opis: <c:out value="${event.description}"/><br>
                Opis wyposazenia: <c:out value="${event.equipmentDescription}"/><br>
                Organizator: <c:out value="${event.organizer.name}"/>

                <div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=${event.place}&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://www.bitgeeks.net/embed-google-map/">how can i see embed on google map</a></div><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style></div>
            </div>
            </div>

        <button onclick="javascript:document.location.href='/participants/join/${event.id}'">Dolacz do wydarzenia</button>
    </c:if>
    <br><br>
</c:forEach>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

<%--@Id--%>
<%--@GeneratedValue(strategy = GenerationType.IDENTITY)--%>
<%--private Long id;--%>

<%--@NotBlank--%>
<%--private String name;--%>

<%--@NotNull--%>
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
