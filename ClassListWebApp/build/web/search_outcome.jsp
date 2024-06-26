<%-- 
    Document   : search_outcome
    Created on : 02 May 2024, 9:48:04 AM
    Author     : Student
--%>

<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.entities.StudentPhoto"%>
<%@page import="za.ac.tut.entities.Students"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Student Outcome Page</title>
    </head>
    <body>
        <h1>Search Student Outcome</h1>
        <%
            Students student = (Students)request.getAttribute("student");
            String name = student.getName();
            String surname = student.getSurname();
            Long stud_no = student.getId();
            StudentPhoto sp = student.getPhoto();
            String photo = "data:image/jpg;Base64," + Base64.getEncoder().encodeToString(sp.getPhoto());
        %>
        <table border="1">
            <th>Photo</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Student Number</th>
            <tr>
                <td><img src="<%=photo%>" width="110" height="120"></td>
                <td><b><%=name%></b></td>
                <td><b><%=surname%></b></td>
                <td><b><%=stud_no%></b></td>
            </tr>
        </table>
        <p>
            Please click <a href="menu.html">here</a> to return to the menu page
            or <a href="index.html">here</a> to the main page.
        </p>
    </body>
</html>
