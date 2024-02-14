package admin_side;
import form.RequestRecord;
 import java.io.IOException;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.List;

 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 @WebServlet("/admin_request_view")
 public class Admin_request_view extends HttpServlet {
     private static final long serialVersionUID = 1L;

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         List<RequestRecord> arequestRecords = new ArrayList<>();
         List<Integer> acknowledgedOrPendingIds = new ArrayList<>();
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resources_management", "root", "root");
        
             String selectQuery = "SELECT * FROM requests";
       
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery();
           
             while (resultSet.next()) {
                 RequestRecord requestRecord = new RequestRecord();
                 requestRecord.setRequestId(resultSet.getInt("request_id"));
                 requestRecord.setSUsn(resultSet.getString("s_usn"));
                 requestRecord.setSName(resultSet.getString("s_name"));
                 requestRecord.setSBranch(resultSet.getString("s_branch"));
                 requestRecord.setSSem(resultSet.getInt("s_sem"));
                 requestRecord.setResource(resultSet.getString("resource"));
                 requestRecord.setRemarks(resultSet.getString("remarks"));
                 requestRecord.setStatus(resultSet.getString("status"));
                 requestRecord.setRequestDate(resultSet.getDate("reqest_date"));
                 arequestRecords.add(requestRecord);
             }
             
             String statusQuery = "SELECT request_id FROM requests WHERE status='acknowledged' OR status='pending'";
             PreparedStatement statusStatement = connection.prepareStatement(statusQuery);
             ResultSet statusResultSet = statusStatement.executeQuery();

             while (statusResultSet.next()) {
                 int requestId = statusResultSet.getInt("request_id");
                 acknowledgedOrPendingIds.add(requestId);
             }

             request.setAttribute("arequestRecords", arequestRecords);
             request.setAttribute("acknowledgedOrPendingIds", acknowledgedOrPendingIds);
             request.getRequestDispatcher("/Admin_request_table.jsp").forward(request, response);
         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
             response.sendRedirect("BranchDataServlet?error=" + e.getMessage());
         }
     }
 }
