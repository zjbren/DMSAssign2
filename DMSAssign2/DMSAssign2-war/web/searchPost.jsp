<%-- 
    Document   : searchPost
    Created on : 3/05/2019, 3:33:54 PM
    Author     : Zach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css" />
        <title>Status Search Page</title>
    </head>
    <body>
        <h1>Status Search</h1>
        <div class="content">
            <%
                if (!(request.getAttribute("error") == null)) {
                    out.print(request.getAttribute("error"));
                }
            %>
            <form method ="POST" name="searchstatus" action="SearchProcess">
                <label>Status: </label>
                <input type="text" name="status_code" value="S0000" size="5" required/>
                <input type="submit" value="Search Status" />
            </form>
            <br>
            <button onclick="location.href = 'home.jsp'" type="button">Return to Home Page</button>
            <form method ="POST" action ="LogoutProcess"><input type="submit" value="logout" name="logout" /></form>

            <%
                out.print("<p>Current User: " + session.getAttribute("user") + "</p>");
            %>
        </div>
    </body>
</html>

