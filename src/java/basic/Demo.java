
package basic;


import jakarta.servlet.*;
import java.io.*;
import java.util.*;
public class Demo extends GenericServlet {
    public void service(ServletRequest req , ServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Enumeration e = req.getParameterNames();
        while(e.hasMoreElements()){
            String n = (String)e.nextElement();
            out.print(n+"=");
            String value = req.getParameter(n);
            out.println(value);
        }
    }
}