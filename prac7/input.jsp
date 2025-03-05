<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Splitter</title>
</head>
<body>
    <h2>Bill Splitter</h2>
    <form action="process.jsp" method="post">
        Total Bill Amount: <input type="text" name="billAmount" required><br><br>
        Number of People: <input type="text" name="numPeople" required><br><br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
