<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Splitter</title>
</head>
<body>
    <h2>Bill Splitter</h2>
    <form action="process.jsp" method="post">
        <label for="billAmount">Total Bill Amount:</label>
        <input type="text" name="billAmount" required>
        <br><br>
        <label for="numPeople">Number of People:</label>
        <input type="text" name="numPeople" required>
        <br><br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
