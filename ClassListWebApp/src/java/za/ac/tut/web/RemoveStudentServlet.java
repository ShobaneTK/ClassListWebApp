/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entities.Students;
import za.ac.tut.model.bl.StudentsFacadeLocal;

/**
 *
 * @author Student
 */
@MultipartConfig
public class RemoveStudentServlet extends HttpServlet {
     @EJB StudentsFacadeLocal sfl;
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long stud_no = Long.parseLong(request.getParameter("stud_no"));
        
        Students student = sfl.find(stud_no);
        
        sfl.remove(student);
        
        request.setAttribute("student", student);
        
        RequestDispatcher disp = request.getRequestDispatcher("remove_outcome.jsp");
        disp.forward(request, response);
    }
}
