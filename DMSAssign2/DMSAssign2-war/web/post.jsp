<%-- 
    Document   : post
    Created on : 3/05/2019, 2:25:11 PM
    Author     : Zach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>    
    <head>
        <title>Status Posting System</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Status Posting System</h1>
        <div class="content">
            <%
                if (!(request.getAttribute("error") == null)) {
                    out.print(request.getAttribute("error"));
                }
            %>
            <form action="PostProcess" name="postStatus" method="POST">
                <label>Status Code (required): </label><input type="text" name="status_code" value="S0000" size="5" required/><br>
                
                <label>Status (required): </label><input type="text" name="status" value="Status" required/><br>
                
                <input type="submit" value="Post" name="post" />  <input type="reset" value="Reset" name="reset" /><br>
                
                <button onclick="location.href='home.jsp'" type="button">Return to Home Page</button>
                <form method ="POST" action ="LogoutProcess"><input type="submit" value="logout" name="logout" /></form>
                
                <%
                    out.print("<p>Current User: " + session.getAttribute("user") + "</p>");
                %>
            </form>
        </div>
    </body>
</html>

