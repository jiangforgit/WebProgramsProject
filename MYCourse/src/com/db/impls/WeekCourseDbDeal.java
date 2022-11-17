package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.WeekcourseTbEntity;
import com.db.interfaces.IWeekCourseDbDeal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Collection;

public class WeekCourseDbDeal extends HibernateDataBase implements IWeekCourseDbDeal {
    @Override
    public boolean createWeekCourse(WeekcourseTbEntity weekcourseTbEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(weekcourseTbEntity);
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
    public Collection queryWeekCourseByStudentId(int studentId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from WeekcourseTbEntity,CourseTbEntity where weekCourseCId = courseId and weekCourseSId =:db_studentId");
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

    @Override
    public Collection queryWeekCourseByCourseId(int courseId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from WeekcourseTbEntity where weekCourseCId =:db_courseId");
            query.setParameter("db_courseId",courseId);

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
