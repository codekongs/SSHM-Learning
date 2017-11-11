import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Address;
import model.User;

/**
 * Created by 尚振鸿 on 17-11-11. 10:44
 * mail:szh@codekong.cn
 */

public class ComponentTest {

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
    public void testConponent(){
        Address address = new Address("江苏省", "常州市", "新北区");
        User user = new User("小白", "123456", address);
        mSession.save(user);
    }


    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
