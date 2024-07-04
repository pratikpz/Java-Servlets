
package basic;

import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.*;


public class SecondServ extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        Cookie[] c = req.getCookies();
        out.println("Welcome "+c[0].getValue());
    }
    
}
