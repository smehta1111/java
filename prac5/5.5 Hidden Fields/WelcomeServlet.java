import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String visitCountStr = request.getParameter("visitCount");
        int visitCount = (visitCountStr == null) ? 0 : Integer.parseInt(visitCountStr);
        
        if (visitCount == 0) {
            out.println("<h1>Welcome Newcomer</h1>");
        } else {
            out.println("<h1>Welcome Back</h1>");
        }
        visitCount++;
        
        // Form with hidden field to track visits
        out.println("<form method='post' action='WelcomeServlet'>");
        out.println("<input type='hidden' name='visitCount' value='" + visitCount + "'>");
        out.println("<input type='submit' value='Refresh'>");
        out.println("</form>");
    }
} 