<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="first.css">
    <title>College Resource Request Portal</title>
</head>
<body>
    <header>
        <h1>Student Resource Connect</h1>
        <nav class="navigationbar">
           
        </nav>
    </header>
    <div class="main-container">
    <div class="form-box" >
        <form action="branchData" method="GET" >
        
            <h2>Student Request Resource</h2>
            <p> Is Something Missing? Let Us Know. Request Your Needed Resources Here. </p>
            <button class="go-to-form-button" type="submit" >Go to form-> </button>
            </form>
        </div>
        
        <div class="form-box">
         <form action="Admin_login.jsp" method=GET >
            <h2>Resource Management Console</h2>
            <p>Manage, Evaluate, and Fulfill Resource Requests.</p>
            <button class="go-to-form-button" type="submit" >Go To LogIn Page-></button>
            </form>
        </div>
    </div>
</body>
</html>
