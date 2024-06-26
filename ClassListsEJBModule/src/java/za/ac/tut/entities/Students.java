/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Student
 */
@Entity
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StudentPhoto photo;
    
    private String name;
    
    private String surname;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date studentTime;

    public Students() {
    }

    public Students(Long id, StudentPhoto photo, String name, String surname, Date studentTime) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.surname = surname;
        this.studentTime = studentTime;
    }

    public StudentPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(StudentPhoto photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getStudentTime() {
        return studentTime;
    }

    public void setStudentTime(Date studentTime) {
        this.studentTime = studentTime;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.Students[ id=" + id + " ]";
    }
    
}
