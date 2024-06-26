/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entities.StudentPhoto;

/**
 *
 * @author Student
 */
@Stateless
public class StudentPhotoFacade extends AbstractFacade<StudentPhoto> implements StudentPhotoFacadeLocal {

    @PersistenceContext(unitName = "ClassListsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentPhotoFacade() {
        super(StudentPhoto.class);
    }
    
}
