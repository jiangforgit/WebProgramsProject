package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.UsersTbEntity;
import com.db.interfaces.IAddUser;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddUser extends HibernateDataBase implements IAddUser {

    @Override
    public boolean createUser(UsersTbEntity usersEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(usersEntity);
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
}
