package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.interfaces.IQueryStudentCourses;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Collection;

public class QueryStudentCourses extends HibernateDataBase implements IQueryStudentCourses {

    @Override
    public Collection queryJoinTbs(int familyUserId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from FamilystudentTbEntity,CoursestudentTbEntity,StudentTbEntity,CourseTbEntity,SchoolTbEntity " +
                    "where familyStudentFId =:db_familyUserId and familyStudentSId = courseStudentSId and courseStudentSId = studentId and courseStudentCId = courseId and courseSchoolId = schoolId");
            query.setParameter("db_familyUserId",familyUserId);

            result = query.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return result;
    }
}
