
package basic;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class SecondHttpServ extends HttpServlet {
   
    public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("uname");
        out.print("Welcome "+uname);
    }
    
}
