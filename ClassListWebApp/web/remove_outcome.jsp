<%-- 
    Document   : remove_outcome
    Created on : 02 May 2024, 10:18:44 AM
    Author     : Student
--%>

<%@page import="za.ac.tut.entities.Students"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Student Page</title>
    </head>
    <body>
        <h1>Remove Student</h1>
        <%
            Students student = (Students) request.getAttribute("student");
            Long stud_no = student.getId();
        %>
        <p>
            Student number <b style="color: rgb(255, 0, 0)"><%=stud_no%></b> has been successfully removed from the class list.
        </p>
        <p>
            Please click <a href="menu.html">here</a> to return to the menu page
            or <a href="index.html">here</a> to the main page.
        </p>
    </body>
</html>
