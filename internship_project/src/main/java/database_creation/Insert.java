package database_creation;

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

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String employeeId = request.getParameter("employeeId");

	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String project = request.getParameter("project");
        String email = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

            String insertQuery = "insert into INFO (name, role, project, email) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, role);
            preparedStatement.setString(3, project);
            preparedStatement.setString(4, email);
            int rowsAffected = preparedStatement.executeUpdate();
       

            if (rowsAffected > 0) {
                //  inserted successfully
                response.sendRedirect("form.jsp?success=true");
            } else {
                // Insertion failed
                response.sendRedirect("form.jsp?success=false");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); 
            response.sendRedirect("form.jsp?success=false&error=" + e.getMessage());
        }

        }
	}


