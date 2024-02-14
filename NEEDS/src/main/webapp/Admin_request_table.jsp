<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="form.RequestRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College Resource Request Portal</title>         
 <link rel="stylesheet" href="admin_request_table.css"/>
    
</head>
<body>
    <header>
        <h1>Resource Management Console</h1>
        <nav class="navigationbar">
           
      <ul>
     <li>
     <form action="update_password.jsp" method="GET">
    <input type="submit" value="change password"></form>
    </li>
     <li>
     <form action="Admin_login.jsp" method="GET">
    <input type="submit" value="logout"></form>
    </li>
    </ul>    
   </nav>
</header>
  <div class="container">
  <div class="table-container">
    <table>
      <thead>
        <tr>
        <th>Request ID</th>
          <th>Date</th>
          <th>USN</th>
          <th>Name</th>
          <th>Branch</th>
          <th>Semester</th>
          <th>Requested Resource</th>
          <th>Remarks</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
     <% 
        List<RequestRecord> recordsList = (List<RequestRecord>) request.getAttribute("arequestRecords");
        if (recordsList != null) {
            for (RequestRecord record : recordsList) { 
            	 String rowClass = ""; // Initialize an empty class for row color

                 if ("Acknowledged".equals(record.getStatus())) {
                     rowClass = "blue_row";
                 } else if (record.getStatus().equals("Provided")) {
                     rowClass = "green_row";
                 } else if (record.getStatus().equals("Rejected")) {
                     rowClass = "brown_row";
                 }

                 // Apply the rowClass to the <tr> element
     %>
     
          <tr class="<%= rowClass %>">
                <td><%= record.getRequestId() %></td>
                <td><%= record.getRequestDate() %></td>
               <td><%= record.getSUsn() %></td>
                <td><%= record.getSName() %></td>
                <td><%= record.getSBranch() %></td>
                <td><%= record.getSSem() %></td>
                <td><%= record.getResource() %></td>
                <td><%= record.getRemarks() %></td>
                <td><%= record.getStatus() %></td>
             
            </tr>
        <% 
            }
        }
        %>
      </tbody>
    </table>
    </div>
    <form action=update_status method=POST class="add-form">
            <h2>Update request status </h2>
            <label for="id">request id:</label>
            <select id="id" name="id" required>
          <% List<Integer> idList = (List<Integer>) request.getAttribute("acknowledgedOrPendingIds");
          
          if (idList != null) {
              for (Integer record : idList) { 
          %>
           <option value="<%= record %>"><%= record %></option>
          <%} }%>
        
</select>
          <label for="status">request id:</label>
          <select id="status" name="status" required>
          <option value="Acknowledged">acknowledged</option>
          <option value="Provided">provided</option>
           <option value="Rejected">Rejected</option>
          </select>
            <button class="add-button" type="submit">update</button>
        </form>
  </div>
 
</body>

</html>
   

