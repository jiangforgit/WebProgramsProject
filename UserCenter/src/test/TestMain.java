package test;

import com.db.entitys.UserAuthsEntity;
import com.db.entitys.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.UUID;

public class TestMain {
    /*private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    public static void main(String[] args){
        //1. 创建配置对象
        Configuration config = new Configuration().configure();
//        config.addClass(MymsgEntity.class);
        config.addClass(UsersEntity.class);
        config.addClass(UserAuthsEntity.class);
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
        UsersEntity entity = new UsersEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setUserName("name");
        entity.setUserLogo("12");
        entity.setUserSex("m");
        session.save(entity);

        UserAuthsEntity authsEntity = new UserAuthsEntity();
        authsEntity.setId(UUID.randomUUID().toString());
        authsEntity.setUserId(entity.getId());
        authsEntity.setIdentityType(0);
        authsEntity.setIdentifier("fier");
        authsEntity.setCredential("psw");
        session.save(authsEntity);
        transaction.commit();
        //9. 关闭会话
        session.close();
        //10. 关闭会话工厂
        sessionFactory.close();
    }*/
}
