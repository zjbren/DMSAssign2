<%-- 
    Document   : register
    Created on : 3/05/2019, 3:03:57 PM
    Author     : Zach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href=" style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sign up to ZachBook</h1>
        <%
            if (!(request.getAttribute("error") == null)) {
                out.print(request.getAttribute("error"));
            }
        %>
        <div class ="content">
        <form method ="POST" action ="RegisterProcess">
            User Name: <input type="text" name= "usrName" required><br>
            Email:     <input type="text" name= "email" required><br>
            Password:  <input type="password" value="FakePSW" name ="pwd" required><br>
            <input type="submit" value="Login" />
        </form>
            <jsp:useBean id="loginBean" class="Beans.LoginBean">
                <%
                out.print("<p>Current User: " + loginBean.getCurrentUser() + "</p>");
                %>
            </jsp:useBean>
        </div>    
    </body>
</html>
