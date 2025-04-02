<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>JSP Scope Demonstration</title>
</head>
<body>
    <h2>JSP Scope Demonstration</h2>

    <% 
        // Page Scope
        pageContext.setAttribute("pageVar", "This is Page Scope");

        // Request Scope
        request.setAttribute("requestVar", "This is Request Scope");

        // Session Scope
        if (session.getAttribute("sessionVar") == null) {
            session.setAttribute("sessionVar", "This is Session Scope");
        }

        // Application Scope
        if (application.getAttribute("applicationVar") == null) {
            application.setAttribute("applicationVar", "This is Application Scope");
        }
    %>

    <p>Page Scope Variable: <%= pageContext.getAttribute("pageVar") %></p>
    <p>Request Scope Variable: <%= request.getAttribute("requestVar") %></p>
    <p>Session Scope Variable: <%= session.getAttribute("sessionVar") %></p>
    <p>Application Scope Variable: <%= application.getAttribute("applicationVar") %></p>

    <hr>
    <p>Current Time: <%= new Date() %></p>
</body>
</html>
