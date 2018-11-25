<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
Użytkownik id: ${employeeId}<br>
Dodaj/edytuj komputer:
<form:form action="/computer/add" modelAttribute="newComputer" method="post">

    <%--<form:hidden path="id"></form:hidden>--%>
    <form:label path="typ">Typ komputera:</form:label>
    <form:select path="typ">
        <form:options items="${typ}"/>
    </form:select><br>
    <form:label path="marka">Marka komputera:</form:label>
    <form:input path="marka"/><br>
    <form:label path="serialNumber">Numer seryjny:</form:label>
    <form:input path="serialNumber"/><br>
    <form:label path="operatingSystem">System operacyjny:</form:label>
    <form:input path="operatingSystem"/><br>
    <form:label path="ipAddress">Adres ip:</form:label>
    <form:input path="ipAddress"/><br>
    <%--<form:hidden path="employee" value="${employeeId}"></form:hidden>--%>
    <input type="submit" value="Zatwierdz"/>
</form:form>
</body>
</html>
