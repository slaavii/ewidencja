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
        <td>Typ</td>
        <td>Marka</td>
        <td>SerialNumber</td>
        <td>PortNumbers</td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${phone}" var="phone">
        <tr>
            <td>${phone.id}</td>
            <td>${phone.marka}</td>
            <td>${phone.employee}</td>
            <td><a href="${pageContext.servletContext.contextPath}/printer/add/${phone.id}">Dodaj telefon</a></td>
                <%--<td><a href="${pageContext.servletContext.contextPath}/phone/add${employee.id}">Dodaj telefon</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/printer/add${employee.id}">Dodaj drukarkę</a></td>
                --%>
            <td><a href="${pageContext.servletContext.contextPath}/printer/delete?phoneId=${employee.id}">Usuń telefon</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.servletContext.contextPath}/phoneAdd">Dodaj Telefon</a>

</body>
</html>
