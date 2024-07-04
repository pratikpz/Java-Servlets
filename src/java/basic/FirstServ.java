
package basic;

import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.*;


 public class FirstServ extends HttpServlet {
    
    public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("un");
        out.println("Hello "+name);
        Cookie ck = new Cookie("una",name);
        res.addCookie(ck);
        out.print("<form action='SecondServ' method='Post'>"); 
        out.print("<button type='Submit'  >go</button>");
        out.print("</form>");

        
    }
    
}
