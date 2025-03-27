import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/VisitServlet")
public class VisitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String lastVisit = (String) session.getAttribute("lastVisit");
        
        // Get the current date and time
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        
        // Set the new last visit time
        session.setAttribute("lastVisit", currentDate);

        out.println("<html><body>");
        out.println("<h2>Welcome to the Visit Tracker</h2>");
        out.println("<p>Current Visit Time: " + currentDate + "</p>");
        
        if (lastVisit == null) {
            out.println("<p>This is your first visit.</p>");
        } else {
            out.println("<p>Last Visit Time: " + lastVisit + "</p>");
        }
        
        out.println("</body></html>");
    }
}
