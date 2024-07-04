package basic;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;


public class FetchMovie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcajava", "root", "");
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM movie")) {

                out.println("<html><body>");
                out.println("<h1>Movie Details</h1>");
                out.println("<table border='1'><tr><th>name</th><th>genre</th><th>length</th><th>Category</th></tr>");

                while (rs.next()) {
                    String name = rs.getString("name");
                    String genre = rs.getString("genre");
                    int length = rs.getInt("length");
                    String category = rs.getString("category");

                    out.println("<tr><td>" + name + "</td><td>" + genre + "</td><td>" + length + "</td><td>" + category + "</td></tr>");
                }
                out.println("</table></body></html>");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
            e.printStackTrace(out);
            
        } finally {
            out.close();
        }
    }
}
