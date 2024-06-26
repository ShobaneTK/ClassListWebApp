/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.StudentPhoto;

/**
 *
 * @author Student
 */
@Local
public interface StudentPhotoFacadeLocal {

    void create(StudentPhoto studentPhoto);

    void edit(StudentPhoto studentPhoto);

    void remove(StudentPhoto studentPhoto);

    StudentPhoto find(Object id);

    List<StudentPhoto> findAll();

    List<StudentPhoto> findRange(int[] range);

    int count();
    
}
