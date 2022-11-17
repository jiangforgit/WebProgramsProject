package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.UUID;

public class TestMain {
    static Session session;

    static Configuration config = null;
    static Transaction tx = null;

    public static void main(String[] args) {

        try {
            config = new Configuration().configure(new File(
                    "UserCenter/src/hibernate.cfg.xml"));

            System.out.println("Creating tables...");

            SessionFactory sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

//            SchemaExport schemaExport = new SchemaExport(config);
//            schemaExport.create(true,true);

            System.out.println("Table created.");

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                tx.rollback();
            } catch (HibernateException e1) {
                e1.printStackTrace();
            }
        } finally {

        }
    }
}
