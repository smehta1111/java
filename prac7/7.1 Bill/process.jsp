<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Calculation</title>
</head>
<body>
    <h2>Bill Calculation Result</h2>
    <%
        try {
            // Get input parameters
            String billStr = request.getParameter("billAmount");
            String peopleStr = request.getParameter("numPeople");

            // Convert to numbers
            double billAmount = Double.parseDouble(billStr);
            int numPeople = Integer.parseInt(peopleStr);

            // Check for zero division
            if (numPeople == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            // Perform division
            double amountPerPerson = billAmount / numPeople;

            // Display result
            out.println("<p>Each person should pay: $" + amountPerPerson + "</p>");
        } catch (ArithmeticException e) {
            out.println("<p style='color:red;'>Error: Cannot divide by zero. Please enter a valid number of people.</p>");
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Error: Please enter valid numerical values.</p>");
        }
    %>
    <br><a href="index.jsp">Go Back</a>
</body>
</html>
