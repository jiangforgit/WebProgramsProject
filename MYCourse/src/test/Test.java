package test;

import com.db.entitys.FamilystudentTbEntity;
import com.db.entitys.FamilyuserTbEntity;
import com.db.entitys.StudentTbEntity;
import com.db.factorys.DbFactory;
import com.factorys.AddFamilyStudentShipFactory;
import com.utils.LoadedUserUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Test {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    public static void main(String[] args){
        System.out.println("test....");
//        testforDbSession();
        testForStudentCourses();
//        testQuery();
    }

    private static void testForStudentCourses(){

        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        AddFamilyStudentShipFactory familyStudentSheepFactory = new AddFamilyStudentShipFactory();

        FamilystudentTbEntity familystudentTbEntity = new FamilystudentTbEntity();
        familystudentTbEntity.setFamilyStudentFId(1);
        familystudentTbEntity.setFamilyStudentRelateType((byte) 1);
        familystudentTbEntity.setFamilyStudentCreateTime(createTime);

        StudentTbEntity studentTbEntity = new StudentTbEntity();
        studentTbEntity.setStudentName("王维");
        studentTbEntity.setStudentSex((byte) 1);
        studentTbEntity.setStudentInterest("棒球");
        studentTbEntity.setStudentMotto("you can you up");
        studentTbEntity.setStudentCreateTime(createTime);

        familyStudentSheepFactory.produce().createFamilyStudentSheep(familystudentTbEntity,studentTbEntity);
    }

    private static void testforDbSession(){
        //1. 创建配置对象
        Configuration config = new Configuration().configure();
//        config.addClass(MymsgEntity.class);
        //2. 创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        //3. 创建会话工厂对象
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        //4. 会话对象
        session = sessionFactory.openSession();
        //5. 开启事务
        transaction = session.beginTransaction();

        //6. 生成专业对象
//        UserEntity majorEntity = new UserEntity("1", "1212");
//        //7. 保存对象进入数据库
//        session.save(majorEntity);
        //8. 提交事务
        transaction.commit();
        //9. 关闭会话
        session.close();
        //10. 关闭会话工厂
        sessionFactory.close();
    }

    private static void testQuery(){
        StudentTbEntity entity = DbFactory.studentDbDeal().queryStudentById(1);
    }
}
