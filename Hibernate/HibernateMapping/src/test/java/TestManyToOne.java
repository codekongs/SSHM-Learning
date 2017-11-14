import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 尚振鸿 on 17-11-14. 22:28
 * mail:szh@codekong.cn
 */

public class TestManyToOne {

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
    public void manyToOneTest(){

    }

    @Test
    public void oneToManyGet(){

    }


    @Test
    public void oneToManyUpdate(){

    }

    @Test
    public void oneToManyDel(){

    }


    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
