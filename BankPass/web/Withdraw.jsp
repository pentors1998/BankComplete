<%-- 
    Document   : Withdraw
    Created on : Oct 25, 2018, 9:51:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Page</title>
    </head>
    <body>
        <h1>Withdraw</h1><hr>
        <h2>Hi , ${account.name}</h2><br>
        <h2>Balance = ${account.balance}</h2><br>
        <form action="WithdrawServlet" method="POST">
            Withdraw : <input type="number" name="withdraw"> <input type="submit" value="withdraw">
        </form>
        <br>
        <br>
        <a href="MyAccount.jsp">BACK</a>
    </body>
</html>
