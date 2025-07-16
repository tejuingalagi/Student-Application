<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup Form</title>
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

        a {
            color: #007BFF;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <h2>Pentagon Space</h2>
    <h3>Application form</h3>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
        <h3 class="error"><%= error %></h3>
    <% } %>

    <form action="signup" method="post">
        <table>
            <tr>
                <td>Enter your Name:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Enter the Phone number:</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>Enter the Mail ID:</td>
                <td><input type="email" name="mail"></td>
            </tr>
            <tr>
                <td>Enter the Branch:</td>
                <td><input type="text" name="branch"></td>
            </tr>
            <tr>
                <td>Enter the Location:</td>
                <td><input type="text" name="location"></td>
            </tr>
            <tr>
                <td>Enter the Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>Confirm the Password:</td>
                <td><input type="password" name="confirm"></td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="Create Account">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    Already have an account? <a href="login.jsp">Login</a>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
