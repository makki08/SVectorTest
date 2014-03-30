<%-- 
    Document   : index
    Created on : 03 25, 14, 2:42:05 PM
    Author     : Simaco.Menzon
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
        <form action="Controller" method="post">
            <textarea name="input">
                

            </textarea>
            <input type="submit" value="Submit" name="submit">
            <input type="submit" value="Train" name="train">
        </form>
        </br>
        <h3> Add pre-graded essays to corpus </h3></br>
        <form action="upload" method="post" enctype="multipart/form-data">
            
            <input type="file" name="file" />
            Grade: <input type="text" name="grade" />
            <button type="submit" name="addfile" value="Add">Add</button>
        </form>
    </body>
</html>
