package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.UsersTbEntity;
import com.db.enums.EnumRegistType;
import com.db.interfaces.IVerifyUser;
import com.utils.PasswordUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class VerifyUser extends HibernateDataBase implements IVerifyUser {

    public VerifyUser(){
        super();
    }

    @Override
    public boolean verifyPassword(String userName,String password){
        try {
            Session session = getSession();
            Query query = session.createQuery("from UsersTbEntity where userRegistType =:registType and userName=:userName");
            query.setParameter("registType", EnumRegistType.localPassword.ordinal());
            query.setParameter("userName",userName);
            UsersTbEntity result = (UsersTbEntity)query.uniqueResult();
            if(null != result){
                String userSaltAndPsd = result.getUserPassword();
                String userSalt = userSaltAndPsd.substring(0,16);
                if(PasswordUtil.verify(password,userSalt,userSaltAndPsd)){
                    return true;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return false;
    }
}
