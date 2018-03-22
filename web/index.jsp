<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Appone</title>
</head>
<body>
<p>Hello World!</p>
<c:forEach items="${lista}" var="u">
    ${u.imie} ${u.nazwisko} <br/>
</c:forEach>
</body>
</html>