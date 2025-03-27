<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Marks Form</title>
</head>
<body>
    <h2>Enter Marks for Three Subjects</h2>
    <form action="process.jsp" method="post">
        Subject 1: <input type="number" name="subject1"><br><br>
        Subject 2: <input type="number" name="subject2"><br><br>
        Subject 3: <input type="number" name="subject3"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
