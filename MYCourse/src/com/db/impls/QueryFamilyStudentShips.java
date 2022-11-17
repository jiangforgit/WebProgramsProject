package com.db.impls;


import com.db.base.HibernateDataBase;
import com.db.interfaces.IQueryFamilyStudentShip;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Collection;

public class QueryFamilyStudentShips extends HibernateDataBase implements IQueryFamilyStudentShip {

    @Override
    public Collection queryFamilyStudentShips(int familyUserId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from  FamilystudentTbEntity ,StudentTbEntity where familyStudentSId = studentId and familyStudentFId =:db_familyUserId");
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
