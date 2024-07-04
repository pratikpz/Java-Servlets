//
//package basic;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import java.io.*;
//
//
//public class MyServlet extends HttpServlet{
//    public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//        out.print("<html><body>");
//        out.println("My web app");
//        out.println("</body></html>");
//    
//        
//    }
//}

package basic;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("un");
        out.print("<html><body>");
        out.println("Hello " + name);
        out.println("</body></html>");
    }
}