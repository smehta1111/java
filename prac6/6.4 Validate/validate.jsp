<%@ page import="java.sql.*" %>
<%
    // Get username and password from request
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Database connection details
    String url = "jdbc:mysql://localhost:3306/your_database";
    String user = "root";
    String dbPassword = "root";

    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish Connection
        Connection conn = DriverManager.getConnection(url, user, dbPassword);

        // Prepare SQL Query
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Redirect to menu.jsp if credentials are correct
            response.sendRedirect("menu.jsp");
        } else {
            // Redirect to msg.jsp if credentials are incorrect
            response.sendRedirect("msg.jsp");
        }
    } catch (Exception e) {
        out.println("<h2>Database Connection Failed: " + e.getMessage() + "</h2>");
    }
%>
