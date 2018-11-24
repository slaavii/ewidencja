<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Ewidencja App</title>
    <link href="${pageContext.servletContext.contextPath}/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
Dodaj/edytuj komputer:
<form:form action="add" modelAttribute="newComputer" method="POST">
    <form:input type="hidden" path="id"/><br>
    <%--<form:label path="typ">Typ komputera:</form:label>--%>
    <%--<form:input path="typ"/><br>--%>
    <form:select path="typ">
        <form:options items="${types}"/>
    </form:select>
    <form:label path="marka">Marka komputera:</form:label>
    <form:input path="marka"/><br>
    <form:label path="serialNumber">Numer seryjny:</form:label>
    <form:input path="serialNumber"/><br>
    <form:label path="operatingSystem">System operacyjny:</form:label>
    <form:input path="operatingSystem"/><br>
    <form:label path="ipAddress">Adres ip:</form:label>
    <form:input path="ipAddress"/><br>

    <input type="submit" name="apply" value="Zatwierdz"/>
</form:form>
</body>
</html>
