<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
Dodaj/edytuj komputer:
<form:form action="add" modelAttribute="newComputer" method="post">
    <form:input type="hidden" path="id"/><br>
    <form:label path="typ">Nazwa wydatku:</form:label>
    <form:input path="typ"/><br>
    <form:label path="marka">Typ wydatku:</form:label>
    <form:input path="marka"/><br>
    <form:label path="serialNumber">Data wydatku:</form:label>
    <form:input path="serialNumber"/><br>
    <form:label path="operatingSystem">Kwota wydatku:</form:label>
    <form:input path="operatingSystem"/><br>
    <form:label path="ipAddress">Kwota wydatku:</form:label>
    <form:input path="ipAddress"/><br>

    <input type="submit" name="apply" value="Zatwierdz"/>
</form:form>
</body>
</html>
