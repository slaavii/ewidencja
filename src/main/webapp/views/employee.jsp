<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
</head>
<body>
<%--<jsp:include page="menu.jsp" />--%>

<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>Stanowisko</td>
        <td>Komputer</td>
        <td>Telefon</td>
        <td>Drukarka</td>
        <td>Lokalizacja</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${employee}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.computers}</td>
            <td>${employee.phones}</td>
            <td>${employee.printers}</td>
            <td>${employee.location}</td>
            <td><a href="${pageContext.servletContext.contextPath}/computer/add/${employee.id}">Dodaj komputer</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/phone/add${employee.id}">Dodaj telefon</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/printer/add${employee.id}">Dodaj drukarkę</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/employee/delete?employeeId=${employee.id}">Usuń pracownika</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.servletContext.contextPath}/employeeAdd">Dodaj pozycję</a>

</body>
</html>
