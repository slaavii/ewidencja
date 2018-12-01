<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
</head>
<body>
<jsp:include page="menu.jsp" />
<h1>Tabela drukarek pracwnika: ${employee.name} ${employee.surname}</h1>
<table>
    <thead>
    <tr>
        <td>Marka</td>
        <td>SerialNumber</td>
        <td></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${printer}" var="printer">
        <tr>
            <td>${printer.marka}</td>
            <td>${printer.serialNumber}</td>
            <td><a href="${pageContext.servletContext.contextPath}/printer/edit?printerId=${printer.id}">Edytuj</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/printer/delete?printerId=${printer.id}">Usuń drukarkę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
