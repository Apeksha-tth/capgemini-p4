<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College Resource Request Portal</title>
<link rel="stylesheet" href="student_form.css"/>
</head>
<body>
 <header>
        <h1>Resource Management Console</h1>
        <nav class="navigationbar">
           
      <ul>
       <li>
     <form action="admin_request_view" method="GET">
    <input type="submit" value="Admin Resource Dashboard"></form>
    </li>
      
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
 <form action=update_pass method="POST" class="record-form">
        <h2>Change Password</h2>
        <label for="old_pass" >Old password:</label>
        <input type="text" id="old_pass" name="old_pass" pattern="[^\x00\n\r\t]{1,20}" title="minimum 2 maximum 20 characters" required>
        <label for="new_pass" >Old password:</label>
        <input type="text" id="new_pass" name="new_pass" pattern="[^\x00\n\r\t]{1,20}" title="minimum 2 maximum 20 characters"  required>
        <input type="submit" value="change password"></form>
</body>
</html>