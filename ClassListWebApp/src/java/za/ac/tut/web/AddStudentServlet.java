/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Collation;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.entities.StudentPhoto;
import za.ac.tut.entities.Students;
import za.ac.tut.model.bl.StudentsFacadeLocal;

/**
 *
 * @author Student
 */
@MultipartConfig
public class AddStudentServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Long stud_no = Long.parseLong(request.getParameter("stud_no"));
        
        Collection<Part> part = request.getParts();
        
        for (Part part1 : part) {
            
            if (part1.getContentType() != null) {
                InputStream imagePart = part1.getInputStream();
                
                byte[] imageByte = convertImageToByte(imagePart);
                
                StudentPhoto sp = new StudentPhoto(imageByte);
                
                Students student = createStudent(sp, name, surname, stud_no);
                
                sfl.create(student);
            }
        }
        
        RequestDispatcher disp = request.getRequestDispatcher("add_outcome.jsp");
        disp.forward(request, response);
        
    }

    private byte[] convertImageToByte(InputStream imagePart) {
        byte[] imageFileBlob = null;
        
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        
        byte[] imageByte = new byte[1024];
        
        int int_byte = 0;
        
        try {
            
            while ( (int_byte = imagePart.read(imageByte)) != -1 ) {
                boas.write(imageByte, 0, int_byte);
            }
            imageFileBlob = boas.toByteArray();
            
        } catch (IOException ex) {
            Logger.getLogger(AddStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return imageFileBlob;
    }

    private Students createStudent(StudentPhoto sp, String name, String surname, Long stud_no) {
        Students student = new Students();
        student.setPhoto(sp);
        student.setName(name);
        student.setSurname(surname);
        student.setStudentTime(new Date());
        student.setId(stud_no);
        return student;
    }
}
