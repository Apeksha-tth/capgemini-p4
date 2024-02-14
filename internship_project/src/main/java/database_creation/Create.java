package database_creation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateDatabaseAndTable")
public class Create extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
            Statement statement = connection.createStatement();

            // SQL statement to create a new database
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS employee";
            statement.executeUpdate(createDatabaseQuery);

            // Close the initial connection
            connection.close();

            // Reconnect using the new database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
            statement = connection.createStatement();

            // SQL statement to create a new table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS INFO (" +
                                      "id INT AUTO_INCREMENT PRIMARY KEY, " +
            		                  "name VARCHAR(50),"+
                                      "role VARCHAR(255), " +
                                      "project VARCHAR(255), " +
                                      "email VARCHAR(30))";
            statement.executeUpdate(createTableQuery);

            out.println("<p>Database and table created successfully</p>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error creating table: " + e.getMessage() + "</p>");
        }
    }
}
