<%-- 
    Document   : Login
    Created on : Oct 25, 2018, 9:09:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>LOGIN</h1><hr>
        <span style="color: red">${message}</span>
        <form action="LoginServlet" method="POST">
            <table>
                <tr>
                    <td>ID : </td>
                    <td><input type="number" name="id" required></td>
                </tr>
                <tr>
                    <td>PIN : </td>
                    <td><input type="password" name="pin" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
