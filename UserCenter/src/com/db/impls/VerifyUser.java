package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.enums.EnumIdentityType;
import com.db.interfaces.IVerifyUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class VerifyUser extends HibernateDataBase implements IVerifyUser {

    public VerifyUser(){
        super();
    }

    @Override
    public boolean verifyPassword(String identifier,String credential){
        Session session = getSession();
        Query query = session.createQuery("select count (*) from UserAuthsEntity where identityType =:identityType and identifier=:identifier and credential=:credential");
        query.setParameter("identityType",EnumIdentityType.passwordlogin.ordinal());
        query.setParameter("identifier",identifier);
        query.setParameter("credential",credential);
        Object result = query.uniqueResult();
        System.out.println("result="+result);
        try {
            if(Integer.parseInt(result.toString())>0){
                return true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return false;
    }
}
