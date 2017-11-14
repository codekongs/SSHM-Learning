import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 尚振鸿 on 17-11-14. 15:56
 * mail:szh@codekong.cn
 */

public class TestClassAnnotation {
    private SessionFactory mSessionFactory;
    private Session mSession;
    private Transaction mTransaction;

    @Before
    public void before(){
        mSessionFactory = new Configuration().configure().buildSessionFactory();
        mSession = mSessionFactory.getCurrentSession();
        mTransaction = mSession.beginTransaction();
    }


    @Test
    public void classAnnotationTest(){
        System.out.println("Test...");
    }

    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
