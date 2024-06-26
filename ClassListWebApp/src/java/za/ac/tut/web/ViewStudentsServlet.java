/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ViewStudentsServlet extends HttpServlet {
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
        List<Students> students = sfl.findAll();
        
        request.setAttribute("students", students);
        
        RequestDispatcher disp = request.getRequestDispatcher("view_outcome.jsp");
        disp.forward(request, response);
    }
}
