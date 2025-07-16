<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="in.pentagon.studentapp.dto.Student"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pentagon Space - Update Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f2f2f2;
        }
        h1 {
            color: #003366;
        }
        h2{
        color:blue;
        }
        form {
            background-color: white;
            padding: 30px;
            margin: auto;
            width: 400px;
            box-shadow: 0px 0px 10px gray;
            border-radius: 10px;
        }
        input[type="text"], input[type="email"], input[type="tel"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }
        .button-group {
            margin-top: 20px;
        }
        .button-group button {
            padding: 10px 20px;
            margin: 5px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
        }
        .update-btn {
            background-color: #4CAF50;
            color: white;
        }
        .back-btn {
            background-color: #007BFF;
            color: white;
        }
    </style>
</head>
<body>
<!-- Calling student object from session object -->
	<%Student s=(Student)session.getAttribute("student"); %>

    <h1>Pentagon Space</h1>
    <h2>Update your account</h2>

    <form action="updateAccount" method="post">
        <label>Enter your Name:</label><br>
        <input type="text" name="name" value="<%=s.getName()%>"><br>

        <label>Enter the Phone number:</label><br>
        <input type="tel" name="phone" value="<%=s.getPhone()%>"><br>

        <label>Enter the Mail ID:</label><br>
        <input type="email" name="mail" value="<%=s.getMail()%>"><br>

        <label>Enter the Branch:</label><br>
        <input type="text" name="branch" value="<%=s.getBranch()%>"><br>

        <label>Enter the Location:</label><br>
        <input type="text" name="loc" value="<%=s.getLoc()%>"><br>

        <div class="button-group">
            <button class="update-btn" type="submit">update account</button>
            <a href="dashboard.jsp">
           <button class="back-btn" type="button">Back</button>
           </a>
        </div>
    </form>

</body>
</html>
    