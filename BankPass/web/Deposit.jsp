<%-- 
    Document   : Deposit
    Created on : Oct 25, 2018, 9:47:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Page</title>
    </head>
    <body>
        <h1>Deposit</h1><hr>
        <h2>Hi , ${account.name}</h2><br>
        <h2>Balance = ${account.balance}</h2><br>
        <form action="DepositServlet" method="POST">
            Deposit : <input type="number" name="deposit"> <input type="submit" value="Deposit">
        </form>
        <br>
        <br>
        <a href="MyAccount.jsp">BACK</a>
    </body>
</html>
