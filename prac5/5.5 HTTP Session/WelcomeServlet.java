import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(true);
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        
        if (visitCount == null) {
            visitCount = 1;
            out.println("<h1>Welcome Newcomer</h1>");
        } else {
            visitCount++;
            out.println("<h1>Welcome Back</h1>");
        }
        
        session.setAttribute("visitCount", visitCount);
        
        out.println("<br><a href='WelcomeServlet'>Refresh</a>");
    }
} 
