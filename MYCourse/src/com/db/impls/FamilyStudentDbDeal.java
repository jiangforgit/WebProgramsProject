package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.FamilystudentTbEntity;
import com.db.entitys.StudentTbEntity;
import com.db.interfaces.IFamilyStudentDbDeal;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FamilyStudentDbDeal extends HibernateDataBase implements IFamilyStudentDbDeal {
    @Override
    public boolean addFamilyAndStudent(FamilystudentTbEntity familystudentTbEntity, StudentTbEntity studentTbEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            Integer sID = (Integer) session.save(studentTbEntity);
            if(sID.intValue()>0){
                familystudentTbEntity.setFamilyStudentSId(sID);
                FamilystudentTbEntity Entity = (FamilystudentTbEntity)session.save(familystudentTbEntity);
                if(Entity == null){
                    System.out.println("Entity null");
                }else {
                    System.out.println("FID = "+Entity.getFamilyStudentFId()+",SID="+Entity.getFamilyStudentSId());
                }
                transaction.commit();
                return true;
            }else {
                transaction.rollback();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return false;
    }
}
