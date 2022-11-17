package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.FamilyuserTbEntity;
import com.db.interfaces.IFamilyUserDbDeal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class FamilyUserDbDeal extends HibernateDataBase implements IFamilyUserDbDeal {
    @Override
    public FamilyuserTbEntity getFamilyUserById(int userId) {
        FamilyuserTbEntity familyuserTbEntity = null;
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from FamilyuserTbEntity where familyUserId =:db_familyUserId");
            query.setParameter("db_familyUserId",userId);

            familyuserTbEntity = (FamilyuserTbEntity) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return familyuserTbEntity;
    }
}
