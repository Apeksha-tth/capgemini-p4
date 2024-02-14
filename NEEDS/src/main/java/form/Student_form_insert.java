package form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertRequest")
public class Student_form_insert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s_usn = (request.getParameter("s_usn")).toUpperCase();
        String s_name = request.getParameter("s_name");
        String s_branch = request.getParameter("s_branch");
        int s_sem = Integer.parseInt(request.getParameter("s_sem"));
        String resource = request.getParameter("resource");
        String remarks = request.getParameter("remarks");

        // Status and current time logic
        String status = "pending";
        LocalDateTime currentTime = LocalDateTime.now();
        Timestamp requestDate = Timestamp.valueOf(currentTime);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resources_management", "root", "root");

            String insertQuery = "INSERT INTO requests (s_usn, s_name, s_branch, s_sem, resource, remarks, status, reqest_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, s_usn);
            preparedStatement.setString(2, s_name);
            preparedStatement.setString(3, s_branch);
            preparedStatement.setInt(4, s_sem);
            preparedStatement.setString(5, resource);
            preparedStatement.setString(6, remarks);
            preparedStatement.setString(7, status);
            preparedStatement.setTimestamp(8, requestDate);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Inserted successfully
               
                String SuccessMessage = "Successfull submission! we will review it soon!!";
                response.getWriter().println("<script>alert('" + SuccessMessage + "');window.location='branchData?success=true';</script>");
            } else {
                // error ide popup torsu
                String errorMessage = "Insertion failed";
                response.getWriter().println("<script>alert('" + errorMessage + "');window.location='branchData?success=true';</script>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
            String errorMessage = "An error occurred: " + e.getMessage();
            response.getWriter().println("<script>alert('" + errorMessage + "');window.location='branchData?success=true';</script>");
        }
    }
}
