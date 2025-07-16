<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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

        table {
            background-color: white;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
            width: 400px;
        }

        td {
            padding: 10px 8px;
        }

        input[type="submit"] {
            background-color: green;
            color: white;
            padding: 8px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .success {
            color: green;
            text-align: center;
        }

        .failure {
            color: red;
            text-align: center;
        }

        a {
            text-decoration: none;
            color: #007BFF;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Pentagon Space</h2>
    <h3>Login</h3>

    <% String success = (String) request.getAttribute("success"); %>
    <% if (success != null) { %>
        <h3 class="success"><%= success %></h3>
    <% } %>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
        <h3 class="failure"><%= error %></h3>
    <% } %>

    <form action="login" method="post">
        <table>
            <tr>
                <td>Enter the mail ID:</td>
                <td><input type="email" name="mail"></td>
            </tr>
            <tr>
                <td>Enter the password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="login">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="forgotpassword.html">Forgot password?</a>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    Don't have an account? <a href="signup.jsp">Signup</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
