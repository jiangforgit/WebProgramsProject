package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.StudentTbEntity;
import com.db.interfaces.IStudentDbDeal;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDbDeal extends HibernateDataBase implements IStudentDbDeal {

    @Override
    public boolean createStudent(StudentTbEntity studentTbEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(studentTbEntity);
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
    public StudentTbEntity queryStudentById(int id) {
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();
            StudentTbEntity entity = session.get(StudentTbEntity.class,id);
            transaction.commit();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return null;
    }
}
