<%-- 
    Document   : number_student_outcome
    Created on : 02 May 2024, 10:27:00 AM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students Page</title>
    </head>
    <body>
        <h1>Number Of Student</h1>
        <%
            Integer number_student = (Integer)request.getAttribute("number_student");
        %>
        <p>
            Number of student : <b style="color: rgb(255, 0, 0)"><%=number_student%></b>
        </p>
        <p>
            Please click <a href="menu.html">here</a> to return to the menu page
            or <a href="index.html">here</a> to the main page.
        </p>
    </body>
</html>
