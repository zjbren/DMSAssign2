<%-- 
    Document   : home
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
            <%
                if (!(request.getAttribute("error") == null)) {
                    out.print(request.getAttribute("error"));
                }
            %>

            <button onclick="location.href = 'post.jsp'" type="button">Make a post</button>
            <button onclick="location.href = 'searchPost.jsp'" type="button">Find a post</button>
            <form method ="POST" action ="LogoutProcess"><input type="submit" value="logout" name="logout" /></form>
            <br>
            <p>Name: Zach Brennan</p> 
            <p>Student ID: 16941261</p>

            <%
                out.print("<p>Current User: " + session.getAttribute("user") + "</p>");
            %>

        </div>
    </body>
</html>
