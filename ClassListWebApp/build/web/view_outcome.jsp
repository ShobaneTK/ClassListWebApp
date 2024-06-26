<%-- 
    Document   : view_outcome
    Created on : 02 May 2024, 10:08:27 AM
    Author     : Student
--%>

<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.entities.StudentPhoto"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Students"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Class List Page</title>
    </head>
    <body>
        <h1>Class List</h1>
        <%
            List<Students> students = (List<Students>) request.getAttribute("students");
        %>
        <table border="1">
            <th>Photo</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Student Number</th>
        <%
            for (int i = 0; i < students.size(); i++) {
              Students stud = students.get(i);
              String name = stud.getName();
              String surname = stud.getSurname();
              Long stud_no = stud.getId();
              StudentPhoto sp = stud.getPhoto();
              String photo = "data:image/jpg;Base64," + Base64.getEncoder().encodeToString(sp.getPhoto());
        %>
            <tr>
                <td><img src="<%=photo%>" width="110" height="120"></td>
                <td><b><%=name%></b></td>
                <td><b><%=surname%></b></td>
                <td><b><%=stud_no%></b></td>
            </tr>
        <%
            }
        %>
        </table>
        <p>
            Please click <a href="menu.html">here</a> to return to the menu page
            or <a href="index.html">here</a> to the main page.
        </p>
    </body>
</html>
