
package basic;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class HttpServ extends HttpServlet{
   
    public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("uname");
        out.println("Hello "+name);
        HttpSession session = req.getSession();
        session.setAttribute("uname", name);
        out.print("<a href='SecondHttpServ'>  Visit</a>");
    }
    
}
