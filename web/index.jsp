<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Appone</title>
</head>
<body>
<p>Hello World!</p>
<jsp:include page="/tresc.jsp">
    <jsp:param name="doWyswietlenia" value="Tekst do wyswietlenia"/>
</jsp:include>
</body>
</html>