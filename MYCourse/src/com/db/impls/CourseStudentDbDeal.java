package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.CourseTbEntity;
import com.db.entitys.CoursestudentTbEntity;
import com.db.interfaces.ICourseStudentDbDeal;
import javafx.print.Collation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;

public class CourseStudentDbDeal extends HibernateDataBase implements ICourseStudentDbDeal {

    @Override
    public boolean createStudentCourse(CoursestudentTbEntity coursestudentTbEntity, CourseTbEntity courseTbEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            Integer sID = (Integer) session.save(courseTbEntity);
            if(sID.intValue()>0){
                coursestudentTbEntity.setCourseStudentCId(sID);
                session.save(coursestudentTbEntity);
                transaction.commit();
                return true;
            }else {
                transaction.rollback();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return false;
    }

    @Override
    public boolean joinExistsStudentCourse(CoursestudentTbEntity coursestudentTbEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(coursestudentTbEntity);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return false;
    }

    @Override
    public Collection queryCoursesByStudentId(int studentId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from CoursestudentTbEntity,CourseTbEntity " +
                    "where  courseStudentSId =:db_studentId and courseStudentCId = courseId");
            query.setParameter("db_studentId",studentId);

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
