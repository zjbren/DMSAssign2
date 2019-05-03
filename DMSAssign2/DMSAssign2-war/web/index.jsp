<%-- 
    Document   : index
    Created on : 3/05/2019, 12:25:59 PM
    Author     : Zach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href=" style.css" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DMS Assignment 2</title>
    </head>
    <body>
        <h1>ZachBook</h1>
        <div class="content">

            <button onclick="location.href = 'login.jsp'" type="button">Login</button>
            <button onclick="location.href = 'register.jsp'" type="button">Sign up to ZachBook</button>
            <br>
            <p>Name: Zach Brennan</p> 
            <p>Student ID: 16941261</p>

            <jsp:useBean id="loginBean" class="Beans.LoginBean">
                <%
                    out.print("<p>Current User: " + loginBean.getCurrentUser() + "</p>");
                %>
            </jsp:useBean>

        </div>
    </body>
</html>
