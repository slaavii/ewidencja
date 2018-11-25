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

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${netdevice}" var="netdevice">
        <tr>
            <td>${netdevice.id}</td>
            <td>${netdevice.marka}</td>
            <td>${netdevice.employee}</td>
            <td><a href="${pageContext.servletContext.contextPath}/netdevice/add/${netdevice.id}">Dodaj telefon</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/netdevice/delete?phoneId=${netdevice.id}">Usuń NetDevice</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.servletContext.contextPath}/netDeviceAdd">Dodaj NetDevice</a>

</body>
</html>
