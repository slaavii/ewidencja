<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
Dodaj/edytuj drukarkę:
<form:form action="/printer/edited/${employeeId}" modelAttribute="newPrinter" method="post">

    <form:hidden path="id"></form:hidden>
    <form:label path="marka">Marka drukarki:</form:label>
    <form:input path="marka"/><br>
    <form:label path="serialNumber">Numer seryjny:</form:label>
    <form:input path="serialNumber"/><br>
    <form:hidden path="employee.id"></form:hidden>
    <input type="submit" value="Zatwierdz"/>
</form:form>
</body>
</html>
