package za.ac.tut.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entities.StudentPhoto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-02T10:51:17")
@StaticMetamodel(Students.class)
public class Students_ { 

    public static volatile SingularAttribute<Students, String> surname;
    public static volatile SingularAttribute<Students, String> name;
    public static volatile SingularAttribute<Students, StudentPhoto> photo;
    public static volatile SingularAttribute<Students, Long> id;
    public static volatile SingularAttribute<Students, Date> studentTime;

}