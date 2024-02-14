<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<link rel="stylesheet" href="form.css"/>

<script>
    const urlParams = new URLSearchParams(window.location.search);
    const successParam = urlParams.get("success");

    if (successParam === "true") {
        alert("Data inserted successfully!");
    } else if (successParam === "false") {
        alert("Data insertion failed.");
    }
</script>

</head>

<body>
  <header>
    <h1>Employee Records</h1>
   
    <nav>
      <ul>
      <li>
       <form action=trial method=GET>
    <input type="submit" value="View Records"></form>
    </li>
    </ul>    
    </nav>
  </header>
  <div class="container">
    <form action=Insert method=POST>
    
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" required>
      <label for="role">Role:</label>
      <input type="text" id="role" name="role" required>
      <label for="project">Project:</label>
      <input type="text" id="project" name="project" required>
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required>
      <input type="submit" value="Submit">
    </form>
  </div>
  <footer ><p align="center">apeksha 4GH20CS005</p></footer>
</body>

</html>