package admin_side; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String providedPassword = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resources_management", "root", "root");
       
            String selectQuery = "SELECT password FROM login";
      
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
          
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (providedPassword.equals(storedPassword)) {
                    response.sendRedirect("admin_request_view");
                } else {
                	 String errorMessage = "invalid password... login failed";
                     response.getWriter().println("<script>alert('" + errorMessage + "');window.location='Admin_login.jsp?success=true';</script>");
               
                   
                }
            } else {
            	
            	 String errorMessage = "No admin registered, contact administration";
                 response.getWriter().println("<script>alert('" + errorMessage + "');window.location='Admin_login.jsp?success=true';</script>");
           
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("Admin_login.jsp?error=" + e.getMessage());
        }
    }
}
