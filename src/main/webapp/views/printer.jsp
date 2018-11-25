<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
</head>
<body>
<jsp:include page="menu.jsp" />

<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Marka</td>
        <td>Pracownik</td>
        <td></td>


    </tr>
    </thead>
    <tbody>

    <c:forEach items="${printer}" var="printer">
        <tr>
            <td>${printer.id}</td>
            <td>${printer.marka}</td>
            <td>${printer.employee.name}</td>
            <%--<td><a href="${pageContext.servletContext.contextPath}/printer/add/${printer.id}">Dodaj drukarkę</a></td>--%>
            <td><a href="${pageContext.servletContext.contextPath}/printer/delete?printerId=${employee.id}">Usuń pracownika</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.servletContext.contextPath}/printerAdd">Dodaj Drukarkę</a>

</body>
</html>
