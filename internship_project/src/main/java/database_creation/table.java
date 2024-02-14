package database_creation;

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

@WebServlet("/table")
public class table extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Record> records = new ArrayList<>();
        System.out.println("out");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
       
            String selectQuery = "SELECT * FROM INFO";
      
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            //parameter illa so executeQuery , (idre prepared statement prepare statement )
            ResultSet resultSet = preparedStatement.executeQuery();
          
            while (resultSet.next()) {
            	
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setName(resultSet.getString("name"));
                record.setRole(resultSet.getString("role"));
                record.setProject(resultSet.getString("project"));
                record.setEmail(resultSet.getString("email"));
                records.add(record);
            }

            // Set the records attribute in the request
            //jsp ge send madakke
            request.setAttribute("records", records);

            // Forward the request to the viewRecords.jsp page
            //jsp ge send madtidivi
            request.getRequestDispatcher("/tablej.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("form.jsp?error=" + e.getMessage());
        }
    }
}
