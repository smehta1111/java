package com.example.lifecycle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LifeCycle")
public class ServletLifeCycle extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Initialized: init() called");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h2>Servlet Life Cycle Example</h2>");
        out.println("<p>Check the server console for life cycle logs.</p>");
        out.println("<a href='LifeCycle?destroy=true'><button>Destroy Servlet</button></a>");
        
        System.out.println("Processing request: service() called");

        // If the request contains `destroy=true`, call destroy()
        if ("true".equals(request.getParameter("destroy"))) {
            destroy();
        }
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed: destroy() called");
    }
}
