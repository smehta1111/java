<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Marks Result</title>
</head>
<body>
    <h2>Student Marks and Grade</h2>

    <%-- Declaration scriptlet for grade calculation method --%>
    <%! 
        public String calculateGrade(int avg) {
            if (avg >= 90) return "A";
            else if (avg >= 80) return "B";
            else if (avg >= 70) return "C";
            else if (avg >= 60) return "D";
            else return "Fail";
        }
    %>

    <%-- Scriptlet block to retrieve inputs and calculate results --%>
    <%
        int subject1 = Integer.parseInt(request.getParameter("subject1"));
        int subject2 = Integer.parseInt(request.getParameter("subject2"));
        int subject3 = Integer.parseInt(request.getParameter("subject3"));

        int total = subject1 + subject2 + subject3;
        int average = total / 3;
        String grade = calculateGrade(average);
    %>

    <%-- Expression scriptlets to display results dynamically --%>
    <p>Total Marks: <%= total %></p>
    <p>Average Marks: <%= average %></p>
    <p>Grade: <%= grade %></p>

</body>
</html>
