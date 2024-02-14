<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@ page import="form.RequestRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College Resource Request Portal</title>         
 <link rel="stylesheet" href="requests_table.css"/>
    
</head>
<body>
    <header>
        <h1>Student Form</h1>
        <nav class="navigationbar">
           
      <ul>
      <li>
     <form action="branchData" method="GET">
    <input type="submit" value="Request form"></form>
    </li>
    <li>
     <form action="first.jsp" method="GET">
    <input type="submit" value="Home"></form>
    </li>
    </ul>    
   </nav>
</header>
  <div class="record-container">
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
        List<RequestRecord> recordsList = (List<RequestRecord>) request.getAttribute("requestRecords");
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
 
</body>

</html>
   

