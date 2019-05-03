<%-- 
    Document   : login
    Created on : 3/05/2019, 2:25:11 PM
    Author     : Zach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href=" style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1 class="h1">Login to ZachBook</h1>

        <div class ="content">
            <%
                if (!(request.getAttribute("error") == null)) {
                    out.print(request.getAttribute("error"));
                }
            %>
            <form method ="POST" action ="LoginProcess">
                User Name: <input type="test" name="user" size ="8" required>
                Password:  <input type="password" name ="pwd" required><br>
                <input type="submit" value="Login" />
            </form>
            <button onclick="location.href = 'register.jsp'" type="button">Sign up to ZachBook</button>
            <button onclick="location.href = 'index.jsp'" type="button">Return to Home</button>
            
            <jsp:useBean id="loginBean" class="Beans.LoginBean">
                <%
                out.print("<p>Current User: " + loginBean.getCurrentUser() + "</p>");  
                %>
            </jsp:useBean>
        </div>
    </body>
</html>
