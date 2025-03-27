import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String userName = request.getParameter("userName");

        int visitCount = 0;
        
        // Get cookies from request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    userName = cookie.getValue();
                }
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }
        
        // Increment visit count
        visitCount++;
        
        // Create cookies without expiry time (session cookies)
        Cookie userCookie = new Cookie("userName", userName);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Add cookies to response (without setting Max-Age)
        response.addCookie(userCookie);
        response.addCookie(visitCookie);
        
        out.println("<html><head><title>Visit Counter</title></head><body>");
        out.println("<h1>Welcome, " + userName + "</h1>");
        out.println("<p>You have visited this site " + visitCount + " times.</p>");
        out.println("</body></html>");
    }
}
