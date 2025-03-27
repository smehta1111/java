<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Grade Result</title>
</head>
<body>
    <h2>Student Grade Result</h2>

    <%! 
        public String calculateGrade(double avg) {
            if (avg >= 90) return "A";
            else if (avg >= 80) return "B";
            else if (avg >= 70) return "C";
            else if (avg >= 60) return "D";
            else return "Fail";
        }
    %>

    <%
        try {
            int subject1 = Integer.parseInt(request.getParameter("subject1"));
            int subject2 = Integer.parseInt(request.getParameter("subject2"));
            int subject3 = Integer.parseInt(request.getParameter("subject3"));

            int total = subject1 + subject2 + subject3;
            double average = total / 3.0;
            String grade = calculateGrade(average);
    %>

    <p>Subject 1: <%= subject1 %></p>
    <p>Subject 2: <%= subject2 %></p>
    <p>Subject 3: <%= subject3 %></p>
    <p>Total Marks: <%= total %></p>
    <p>Average Marks: <%= average %></p>
    <p>Grade: <%= grade %></p>

    <%
        } catch (Exception e) {
    %>
        <p style="color: red;">Please enter valid marks for all subjects.</p>
    <%
        }
    %>
</body>
</html>
