import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import bean.User;


/**
 * Created by 尚振鸿 on 17-11-11. 13:47
 * mail:szh@codekong.cn
 */

public class TestPrimaryCache {
    private SessionFactory mSessionFactory;
    private Session mSession;
    private Transaction mTransaction;

    @Before
    public void before() {
        mSessionFactory = new Configuration().configure().buildSessionFactory();
        mSession = mSessionFactory.getCurrentSession();
        mTransaction = mSession.beginTransaction();
    }

    @Test
    public void init(){
        User user1 = new User("1", "张三", "123");
        User user2 = new User("2", "李四", "123");
        User user3 = new User("3", "王五", "123");
        User user4 = new User("4", "赵六", "123");

        mSession.save(user1);
        mSession.save(user2);
        mSession.save(user3);
        mSession.save(user4);
    }

    @Test
    public void sameSessioTest(){
        //一级缓存是在session级别的
        User user1 = mSession.load(User.class, "1");
        User user2 = mSession.load(User.class, "1");
        System.out.println(user1.getUsername());
        System.out.println(user2.getUsername());
    }

    @Test
    public void diffSessionTest(){
        Session session1 = mSessionFactory.openSession();
        Session session2 = mSessionFactory.openSession();
        User user1 = session1.get(User.class, "1");
        User user2 = session2.get(User.class, "2");
        session1.clear();
        session2.close();
    }

    @Test
    public void evictTest(){
        //evict()可以将对象从一级缓存里面清除
        User user1 = mSession.get(User.class, "1");
        System.out.println(user1.getPassword());

        mSession.evict(user1);

        User user2 = mSession.get(User.class, "1");
        System.out.println(user2.getPassword());
    }

    @Test
    public void clearTest(){
        //clear()可以清除一级缓存中的所有对象
        User user1 = mSession.get(User.class, "1");
        System.out.println(user1.getPassword());

        mSession.clear();

        User user2 = mSession.get(User.class, "1");
        System.out.println(user2.getPassword());
    }

    @Test
    public void testQuery(){
        //query.list()方法不使用缓存
        Query<User> query = mSession.createQuery("from User");
        List<User> userList = query.list();
        for (User user : userList){
            System.out.println(user);
        }

        System.out.println();

        userList = query.list();
        for (User user : userList){
            System.out.println(user.getPassword());
        }
    }

    @Test
    public void testIterate(){
        //query.iterate()使用缓存

        Query<User> query = mSession.createQuery("from User");
        List<User> userList = query.list();
        for (User user : userList){
            System.out.println(user);
        }

        System.out.println();

        Iterator<User> iterator = query.iterate();
        while (iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }
    }

    @Test
    public void iterate2(){
        //query.iterate()使用缓存,先从数据库查询到所有的id,
        // 然后通过id区查找缓存,缓存中查找失败再去数据库查询
        Query<User> query = mSession.createQuery("from User ");
        Iterator<User> iterator = query.iterate();
        while (iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }
    }

    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}

