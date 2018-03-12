package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.UserAuthsEntity;
import com.db.entitys.UsersEntity;
import com.db.interfaces.IAddUser;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddUser extends HibernateDataBase implements IAddUser {

    @Override
    public boolean createUser(UsersEntity usersEntity, UserAuthsEntity userAuthsEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(usersEntity);
            session.save(userAuthsEntity);
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
