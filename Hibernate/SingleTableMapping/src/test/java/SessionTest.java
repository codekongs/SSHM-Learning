import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import model.Student;

/**
 * Created by 尚振鸿 on 17-11-8. 14:05
 * mail:szh@codekong.cn
 */

public class SessionTest {
    private SessionFactory mSessionFactory;
    private Session mSession;
    private Transaction mTransaction;

    @Before
    public void before(){
        mSessionFactory = new Configuration().configure().buildSessionFactory();
        //必须在hibernate.cfg.xml中配置 <property name="current_session_context_class">thread</property>
        mSession = mSessionFactory.getCurrentSession();
        mTransaction = mSession.beginTransaction();
    }

    @Test
    public void testSession(){
        Student student = new Student(1, "李四", "男", new Date(), "上海", null);
        mSession.save(student);
    }

    @Test
    public void testOpenSession(){
        Session session1 = mSessionFactory.openSession();
        session1.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("session1 hashCode = " + connection.hashCode()
                        + "\n" + "connection1 = " + connection);
            }
        });

        Session session2 = mSessionFactory.openSession();
        session2.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("session2 hashCode = " + connection.hashCode()
                        + "\n" + "connection2 = " + connection);
            }
        });
        System.out.println("session1 = " + session1);
        System.out.println("session2 = " + session2);

        mTransaction.commit();
        session1.close();
        session2.close();
        mSessionFactory.close();
        System.out.println("close session1 = " + session1);
        System.out.println("close session2 = " + session2);
    }

    @Test
    public void testGetCurrentSession(){
        Session session1 = mSessionFactory.getCurrentSession();
        Session session2 = mSessionFactory.getCurrentSession();
        session1.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("session1 hashCode = " + connection.hashCode()
                        + "\n" + "connection1 = " + connection);
            }
        });

        session2.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("session2 hashCode = " + connection.hashCode()
                        + "\n" + "connection2 = " + connection);
            }
        });

        System.out.println("session1 = " + session1);
        System.out.println("session2 = " + session2);

        mTransaction.commit();
        //不需要手动关闭Session
        //session1.close();
        //session2.close();
        mSessionFactory.close();
        System.out.println("close session1 = " + session1);
        System.out.println("close session2 = " + session2);
    }

   /* @After
    public void after(){
        //提交事务
        mTransaction.commit();
        mSession.close();
        mSessionFactory.close();
    }*/
}
