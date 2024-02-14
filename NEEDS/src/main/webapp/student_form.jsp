<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="form.BranchRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>College Resource Request Portal</title>
    <link rel="stylesheet" href="student_form.css"/>
    
</head>
<body>
    <header>
        <h1>Student Request Form</h1>
        <nav class="navigationbar">
           
      <ul>
      <li>
     <form action="Student_view" method="GET">
    <input type="submit" value="Requests and Status"></form>
    </li>
     <li>
     <form action="first.jsp" method="GET">
    <input type="submit" value="Home"></form>
    </li>
    
    </ul>    
   
        </nav>
    </header>
    <form action="InsertRequest" method="POST" class="record-form">
        <h2>New Request</h2>
        <label for="s_usn" >USN:</label>
        <input type="text" id="s_usn" name="s_usn" pattern="^[1-9][A-Za-z]{2}\d{2}[A-Za-z]{2}\d{3}$" title="usn must be of form 1GH20CE005 etc" required>
        <label for="s_name" >Name:</label>
        <input type="text" id="s_name" name="s_name" pattern="[A-Za-z]{3,}" title="name cant be less than 3 letters!" required>
        <label for="s_branch">Branch:</label>
        <select id="s_branch" name="s_branch" required>
            
         <% 
                List<BranchRecord> branchesList = (List<BranchRecord>) request.getAttribute("branches");
                if (branchesList != null) {
                    for (int i = 0; i < branchesList.size(); i++) {
                        BranchRecord branch = branchesList.get(i);
            %>
            <option value="<%= branch.getBranch() %>"><%= branch.getBranch() %></option>
            <%
                    }
                }
            %>
</select>
        <label for="s_sem">Semester:</label>
        <select id="s_sem" name="s_sem" required>
            
        <% 
                for (int semester = 1; semester <= 8; semester++) {
            %>
            <option value="<%= semester %>"><%= semester %>th semester</option>
            <%
                }
            %>
</select>
        <label for="resource">Resource:</label>
        <select id="resource" name="resource" required>
        <option value="Book for department library">Book for department library</option>
        <option value="Electronic gadgets">Electronic gadgets</option>
        <option value="Furniture">Furniture</option>
        <option value="Consumbles">Consumables</option>
        <option value="Lab instruments">Lab instruments</option>
        <option value="other">other</option>
        </select>
        <label for="remarks">Remarks:</label>
        <input type="text" id="remarks" name="remarks" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
