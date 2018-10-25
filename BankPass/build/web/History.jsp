<%-- 
    Document   : History
    Created on : Oct 25, 2018, 10:36:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>
        <h1>History</h1><hr>
        <h2>Username : ${account.name}</h2><br>
        <h3><a href="MyAccount.jsp">BACK</a></h3><br>
        <table border="2">
            <tr>
                <th>#</th>
                <th>Date</th>
                <th>Method</th>
                <th>Amount</th>
                <th>Balance</th>
            </tr>
            <c:forEach items="${history}" var="h" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${h.time}</td>
                    <td>${h.method}</td>
                    <td>${h.amount}</td>
                    <td>${h.balance}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
