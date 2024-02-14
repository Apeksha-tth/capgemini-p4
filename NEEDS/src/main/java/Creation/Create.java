//package Creation;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/Create")
//public class Create extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
//            Statement statement = connection.createStatement();
//
//            // SQL statement to create a new database
//            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS Resources_management";
//            statement.executeUpdate(createDatabaseQuery);
//
//            // Close the initial connection
//            connection.close();
//
//            // Reconnect using the new database
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resources_management", "root", "root");
//            statement = connection.createStatement();
//
//          
//            String createBranchesTableQuery = "CREATE TABLE IF NOT EXISTS branches (" +
//                    "branch VARCHAR(100) PRIMARY KEY)";
//            statement.executeUpdate(createBranchesTableQuery);
//
//
//           
//         
//            String createRequestsTableQuery = "CREATE TABLE IF NOT EXISTS requests (" +
//                    "request_id INT AUTO_INCREMENT PRIMARY KEY, " +
//                    "s_usn VARCHAR(10), " +
//                    "s_name VARCHAR(255), " +
//                    "s_branch VARCHAR(100), " +
//                    "s_sem INT, " +
//                    "resource VARCHAR(255), " +
//                    "remarks VARCHAR(1000), " +
//                    "status VARCHAR(25), " +
//                    "reqest_date DATE, " +
//                    "FOREIGN KEY (s_branch) REFERENCES branches(branch))";
//            statement.executeUpdate(createRequestsTableQuery);
//            String insertQuery="INSERT INTO branches values (\"computer Science and Engineering\")";
//            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//            @SuppressWarnings("unused")
//			int rowsAffected = preparedStatement.executeUpdate();
//            String insertQuery2="INSERT INTO branches values (\"Electronics and Communication\")";
//            preparedStatement = connection.prepareStatement(insertQuery2);
//            @SuppressWarnings("unused")
//			int rowsAffected2 = preparedStatement.executeUpdate();
//           String insertQuery3="INSERT INTO branches values (\"Mechanical\")";
//            preparedStatement = connection.prepareStatement(insertQuery3);
//            @SuppressWarnings("unused")
//			int rowsAffected3 = preparedStatement.executeUpdate();
//            String insertQuery4="INSERT INTO branches values (\"Civil\")";
//            preparedStatement = connection.prepareStatement(insertQuery4);
//            @SuppressWarnings("unused")
//			int rowsAffected4 = preparedStatement.executeUpdate();
//            
//            
//            String createLoginTableQuery = "CREATE TABLE IF NOT EXISTS login (" +
//                    "user VARCHAR(100) PRIMARY KEY,"
//                    + "password VARCHAR(20))";
//            statement.executeUpdate(createLoginTableQuery);
//            
//            insertQuery="INSERT INTO login values (\"Admin\",\"admin@123\")";
//            preparedStatement = connection.prepareStatement(insertQuery);
//            @SuppressWarnings("unused")
//			int rowsAffected5 = preparedStatement.executeUpdate();
//
//            		
//
//            out.println("<p>Database and tables created successfully</p>");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            out.println("<p>Error creating tables: " + e.getMessage() + "</p>");
//        }
//    }
//}
