package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.ScheduletaskTbEntity;
import com.db.interfaces.IScheduleTaskDbDeal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;

public class ScheduleTaskDbDeal extends HibernateDataBase implements IScheduleTaskDbDeal {
    @Override
    public boolean createScheduleTask(ScheduletaskTbEntity scheduletaskTbEntity) {
        Session session = getSession();
        try{
            Transaction transaction = session.beginTransaction();
            Integer ID = (Integer) session.save(scheduletaskTbEntity);
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
    public Collection queryScheduleTasksByCreatorId(int userId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from ScheduletaskTbEntity where scheduleTaskCreator =:db_creatorId");
            query.setParameter("db_creatorId",userId);

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

    @Override
    public Collection queryScheduleTasksWithSharer(int userId) {
        Collection result = new ArrayList();
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from ScheduletaskTbEntity,FamilyuserTbEntity where scheduleTaskCreator = familyUserId and " +
                    "(scheduleTaskCreator =:db_creatorId or (scheduleTaskCreator in " +
                    "(select distinct familyStudentFId from FamilystudentTbEntity where familyStudentFId !=:db_creatorId and familyStudentSId in " +
                    "(select familyStudentSId from FamilystudentTbEntity where familyStudentFId =:db_creatorId)) and scheduleTaskFullShare = 1))");
            query.setParameter("db_creatorId",userId);

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

    @Override
    public Object queryScheduleTasksByTaskId(int taskId) {
        Object resultObj = null;
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from ScheduletaskTbEntity,FamilyuserTbEntity where scheduleTaskCreator =familyUserId and scheduleTaskId =:db_taskId");
            query.setParameter("db_taskId",taskId);

            resultObj = query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
            closeSessionFactory();
        }
        return resultObj;
    }

    @Override
    public boolean deleteScheduleTaskById(int id) {
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();
            ScheduletaskTbEntity scheduletaskTbEntity = new ScheduletaskTbEntity();
            scheduletaskTbEntity.setScheduleTaskId(id);
            session.delete(scheduletaskTbEntity);
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
