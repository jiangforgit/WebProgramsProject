import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

public class Test {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    public static void main(String[] args){
        System.out.println("test....");

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
}
