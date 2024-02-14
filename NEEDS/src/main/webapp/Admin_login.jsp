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
     <form action="first.jsp" method="POST">
    <input type="submit" value="Back"></form>
    </li>
    </ul>
    </nav>
    </header>
    <form action="login" method="POST" class="record-form">
        <h2>Admin Login</h2>
        <label for="s_usn" >password:</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Login</button>
    </form>
</body>
</html>
