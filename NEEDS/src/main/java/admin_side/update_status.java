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

@WebServlet("/update_status")
public class update_status extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int requestId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resources_management", "root", "root");
            
            
            String updateQuery = "UPDATE requests SET status = ? WHERE request_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, requestId);
            
           
            int rowsUpdated = preparedStatement.executeUpdate();
            
            if (rowsUpdated > 0) {
                
                response.sendRedirect("admin_request_view");
            } else {
                
            	 String errorMessage = "ops! status update failed..";
                 response.getWriter().println("<script>alert('" + errorMessage + "');window.location='admin_request_view?success=true';</script>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("admin_request_view?error=" + e.getMessage());
        }
    }
}
