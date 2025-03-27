<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <%
        session.invalidate(); // Destroy session
    %>
    <h2>You have been logged out.</h2>
    <p><a href="index.jsp">Go to Login Page</a></p>
</body>
</html>
