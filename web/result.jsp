<%-- 
    Document   : result
    Created on : Mar 30, 2014, 9:15:34 PM
    Author     : makki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="result">
            <h3>${requestScope["message"]}</h3>
        </div>
    </body>
</html>
