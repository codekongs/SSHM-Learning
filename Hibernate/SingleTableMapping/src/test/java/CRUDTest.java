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
 * Created by 尚振鸿 on 17-11-11. 11:10
 * mail:szh@codekong.cn
 */

public class CRUDTest {
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
    public void testSave(){
        Address address = new Address("江苏省", "常州市", "新北区");
        User user = new User("小白", "123456", address);
        mSession.save(user);
    }

    @Test
    public void testGet(){
        User user = mSession.get(User.class, 1);
        System.out.println(user);
    }

    @Test
    public void testLoad(){
        //load第一次只返回代理对象,包含主属性,当使用非主属性时再获取,查询不到会抛异常
        User user = mSession.load(User.class, 1);
        System.out.println(user.toString());
    }

    @Test
    public void testUpdate(){
        User user = mSession.load(User.class, 1);
        user.setPassword("1356");
        mSession.update(user);
    }

    @Test
    public void testDelete(){
        User user = mSession.load(User.class, 1);
        mSession.delete(user);
    }

    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
