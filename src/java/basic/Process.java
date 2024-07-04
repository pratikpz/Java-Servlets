package basic;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

public class Process extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("mname");
        String genre = request.getParameter("mgenre");
        int length = Integer.parseInt(request.getParameter("mlength"));
        String category = request.getParameter("mcategory");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcajava", "root", "");
            PreparedStatement pst = con.prepareStatement("insert into movie values (?, ?, ?, ?)");

            pst.setString(1, name);
            pst.setString(2, genre);
            pst.setInt(3, length);
            pst.setString(4, category);

            int result = pst.executeUpdate();

            out.println(result + " row inserted");
            pst.close();
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
            e.printStackTrace(out);
        }
    }
}
