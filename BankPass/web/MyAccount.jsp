<%-- 
    Document   : MyAccount
    Created on : Oct 25, 2018, 9:20:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account Page</title>
    </head>
    <body>
        <h1>Your Account</h1><hr>
        <h2>Hello , ${account.name}</h2><br>
        <h2>Balance : ${account.balance}</h2>
        <br>
        <span style="color: aquamarine">${status}</span>
        <br>
        <h3><a href="DepositPageServlet">Deposit</a></h3>
        <h3><a href="WithdrawPageServlet">Withdraw</a></h3>
        <h3><a href="HistoryServlet">History</a></h3>
        <br>
        <h3><a href="LogoutServlet">LOGOUT</a></h3>
    </body>
</html>
