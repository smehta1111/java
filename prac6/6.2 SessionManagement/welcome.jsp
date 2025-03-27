<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <%
        // Retrieve username from form submission
        String username = request.getParameter("username");

        // Check if session attribute exists, if not, set it
        if (username != null && !username.isEmpty()) {
            session.setAttribute("user", username);
        }

        // Retrieve session data
        String user = (String) session.getAttribute("user");

        // If no session exists, redirect to login
        if (user == null) {
            response.sendRedirect("index.jsp");
        } else {
    %>
        <h2>Welcome, <%= user %>!</h2>
        <p>Your session ID: <%= session.getId() %></p>
        <p><a href="logout.jsp">Logout</a></p>
    <%
        }
    %>
</body>
</html>
