package admin_side;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update_pass")
public class update_pass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oldPassword = request.getParameter("old_pass");
        String newPassword = request.getParameter("new_pass");
        
      
        String loggedInUser = "admin"; 
        
       

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resources_management", "root", "root");

            // Check if old password matches
            String selectQuery = "SELECT password FROM login WHERE user = ? AND password = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, loggedInUser);
            selectStatement.setString(2, oldPassword);
            if (selectStatement.executeQuery().next()) {
                // Update the new password
                String updateQuery = "UPDATE login SET password = ? WHERE user = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, newPassword);
                updateStatement.setString(2, loggedInUser);
                updateStatement.executeUpdate();

                String successMessage = "password updation successfull";
                response.getWriter().println("<script>alert('" + successMessage + "');window.location='update_password.jsp?success=true';</script>"); 
            } else {
            	 String errorMessage = "invalid old password... failed to update password";
                 response.getWriter().println("<script>alert('" + errorMessage + "');window.location='update_password.jsp?success=true';</script>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("update_password.jsp?error=" + e.getMessage());
        }
    }
}
