<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Calculation</title>
</head>
<body>
    <h2>Bill Splitter Result</h2>

    <%
        try {
            // Get input values
            String billAmountStr = request.getParameter("billAmount");
            String numPeopleStr = request.getParameter("numPeople");

            // Convert to numeric values
            double billAmount = Double.parseDouble(billAmountStr);
            int numPeople = Integer.parseInt(numPeopleStr);

            // Perform division
            double share = billAmount / numPeople;

            // Display result
            out.println("<p>Each person should pay: ₹" + String.format("%.2f", share) + "</p>");
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Error: Invalid input. Please enter valid numbers.</p>");
        } catch (ArithmeticException e) {
            out.println("<p style='color:red;'>Error: Division by zero is not allowed.</p>");
        }
    %>

    <br>
    <a href="input.jsp">Go Back</a>
</body>
</html>
