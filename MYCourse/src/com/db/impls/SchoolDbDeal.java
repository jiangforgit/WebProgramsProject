package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.SchoolTbEntity;
import com.db.interfaces.ISchoolDbDeal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;

public class SchoolDbDeal extends HibernateDataBase implements ISchoolDbDeal {

    @Override
    public boolean createSchool(SchoolTbEntity schoolTbEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            //在hbm xml 中设置 <generator></generator> 则save or update 后会反赋值ID到持久化
            Integer ID = (Integer) session.save(schoolTbEntity);//schoolTbEntity.getSchoolId()也可以获取到ID
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
    public Collection querySchoolByUserId(byte creatorType, int userId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from SchoolTbEntity where schoolCreatorType =:db_creatorType and schoolCreatorUserId =:db_creatorUserId");
            query.setParameter("db_creatorType",creatorType);
            query.setParameter("db_creatorUserId",userId);

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
