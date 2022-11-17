package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.enums.EnumSchoolCreatorType;
import com.db.interfaces.IQuerySchoolCourse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;

public class QuerySchoolCourse extends HibernateDataBase implements IQuerySchoolCourse {
    @Override
    public Collection querySchoolCourses(EnumSchoolCreatorType creatorType, int ID) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from SchoolTbEntity, CourseTbEntity where schoolCreatorType =:db_creatorType and schoolCreatorUserId =:db_creatorUserId and" +
                    " courseSchoolId = schoolId");
            query.setParameter("db_creatorType",creatorType.ordinal());
            query.setParameter("db_creatorUserId",ID);

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
