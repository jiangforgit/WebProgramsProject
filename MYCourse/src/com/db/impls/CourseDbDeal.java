package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.interfaces.ICourseDbDeal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Collection;

public class CourseDbDeal extends HibernateDataBase implements ICourseDbDeal {
    @Override
    public Collection queryCoursesBySchoolId(int schoolId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from CourseTbEntity where courseSchoolId =:db_schoolId");
            query.setParameter("db_schoolId",schoolId);

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
