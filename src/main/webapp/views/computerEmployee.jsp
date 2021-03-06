<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
</head>
<body>
<jsp:include page="menu.jsp" />
<h1>Tabela komputerów pracwnika: ${employee.name} ${employee.surname}</h1>
<table>
    <thead>
    <tr>
        <td>Typ</td>
        <td>Marka</td>
        <td>SerialNumber</td>
        <td>SystemOperacyjny</td>
        <td>AdresIP</td>
        <td></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${computer}" var="computer">
        <tr>
            <td>${computer.typ}</td>
            <td>${computer.marka}</td>
            <td>${computer.serialNumber}</td>
            <td>${computer.operatingSystem}</td>
            <td>${computer.ipAddress}</td>
            <td><a href="${pageContext.servletContext.contextPath}/computer/edit?computerId=${computer.id}">Edytuj</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/computer/delete?computerId=${computer.id}">Usuń komputer</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
