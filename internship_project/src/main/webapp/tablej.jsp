<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>  
 
<%@ page import="database_creation.Record" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Records</title>
<link rel="stylesheet" href="table.css"/>
</head>
<body>
  <header>
    <h1>Employee Records</h1>
    
    <nav>
      <ul>
        <li><a href="form.jsp">Home</a></li>
      </ul>
    </nav>
  </header>
  <div class="table-container">
    <table>
      <thead>
        <tr>
        <th>ID</th>
          <th>Name</th>
          <th>Role</th>
          <th>Project</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
     <% 
       
        if (recordsList != null) {
            for (Record record : recordsList) { 
      %>
            <tr>
                <td>${record.name} </td>
                 <td>${record.role} </td>
                 <td>${record.project} </td>
                 <td>${record.email} </td>
             
            </tr>
        <% 
            }
        }
        %>
      </tbody>
    </table>
    <a href="form.jsp" class="add-link">Add</a>
  </div>
 
</body>

</html>
