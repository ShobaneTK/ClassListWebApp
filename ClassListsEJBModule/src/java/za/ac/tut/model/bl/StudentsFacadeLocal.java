/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.Students;

/**
 *
 * @author Student
 */
@Local
public interface StudentsFacadeLocal {

    void create(Students students);

    void edit(Students students);

    void remove(Students students);

    Students find(Object id);

    List<Students> findAll();

    List<Students> findRange(int[] range);

    int count();
    
}
