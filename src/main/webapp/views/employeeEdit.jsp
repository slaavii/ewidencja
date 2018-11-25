<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
<h1>Dodajesz pracownika:</h1>
<form:form action="/employee/editedEmployee" modelAttribute="newEmployee" method="post">

    <form:label path="name">Imię pracownika:</form:label>
    <form:input path="name"/><br>
    <form:label path="surname">Nazwisko:</form:label>
    <form:input path="surname"/><br>
    <form:label path="position">Stanowisko:</form:label>
    <form:input path="position"/><br>
    <form:label path="location">Miejsce pracy:</form:label>
    <form:input path="location"/><br>

    <input type="submit" value="Zatwierdz"/>
</form:form>
</body>
</html>
