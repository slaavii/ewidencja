<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cost Control App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
</head>
<body>
<%--<jsp:include page="menu.jsp" />--%>

<table>
    <thead>
    <tr>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>Kiedy</td>
        <td>Czym placone</td>
        <td>Szczegoly</td>
        <td></td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${employee}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.computers}</td>
            <td>${employee.phones}</td>
            <td>${employee.printers}</td>
            <td>${employee.location}</td>
            <td><a href="${pageContext.servletContext.contextPath}/cost/${cost.id}">Przejdz</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/cost/delete?costId=${cost.id}">Usun</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.servletContext.contextPath}/cost/add">Dodaj wydatek</a>

</body>
</html>
