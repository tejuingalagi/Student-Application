<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h2 {
            text-align: center;
        }

        h3 {
            text-align: center;
            color: blue;
        }

        .error {
            color: red;
            text-align: center;
        }

        table {
            background-color: white;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
            width: 450px;
        }

        td {
            padding: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: green;
            color: white;
            padding: 8px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .back-button {
            background-color: #007BFF;
            padding: 8px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .back-button a {
            color: white;
            text-decoration: none;
        }

        .back-button a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2>Pentagon Space</h2>
    <h3>Reset your password here</h3>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
        <h3 class="error"><%= error %></h3>
    <% } %>

    <form action="resetpassword" method="post">
        <table>
            <tr>
                <td>Enter the Phone number:</td>
                <td><input type="text" name="phone" required></td>
            </tr>
            <tr>
                <td>Enter the Mail ID:</td>
                <td><input type="email" name="mail" required></td>
            </tr>
            <tr>
                <td>Enter the password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Confirm the password:</td>
                <td><input type="password" name="confirm" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Reset Password">
                    &nbsp;&nbsp;
                    <button class="back-button"><a href="login.jsp">Back</a></button>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
