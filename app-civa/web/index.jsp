<%-- 
    Document   : index
    Created on : 4 de nov de 2021, 02:13:07
--%>

    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CIVA</title>
    </head>
    <body>
        
        <%
        String redirectURL = "./login/";
        session.invalidate();
        response.sendRedirect(redirectURL);
        %>
    </body>
    <!-- comment -->
</html>
