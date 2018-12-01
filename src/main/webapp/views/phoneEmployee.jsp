<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
</head>
<body>
<jsp:include page="menu.jsp" />
<h1>Tabela telefonów pracwnika: ${employee.name} ${employee.surname}</h1>
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
    <c:forEach items="${phone}" var="phone">
        <tr>
            <td>${phone.marka}</td>
            <td>${phone.serialNumber}</td>
            <td><a href="${pageContext.servletContext.contextPath}/phone/edit?phoneId=${phone.id}">Edytuj</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/phone/delete?phoneId=${phone.id}">Usuń telefon</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
