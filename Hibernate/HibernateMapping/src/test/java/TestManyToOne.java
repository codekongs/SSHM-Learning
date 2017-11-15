import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Department;
import bean.User;

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
        Department department = new Department("综合事业部");
        User user1 = new User("小红", "123456", department);
        User user2 = new User("小白", "56789", department);
        mSession.save(department);
        mSession.save(user1);
        mSession.save(user2);

    }

    @Test
    public void manyToOneGet(){
        Department department = mSession.get(Department.class, 1);
        System.out.println(department);
        User user = mSession.get(User.class, department.getCode());
        System.out.println(user);

        User user1 = mSession.get(User.class, 1);
        System.out.println(user.getDepartment());
    }


    @Test
    public void manyToOneUpdate(){
        Department department = new Department("无线事业群");
        User user1 = mSession.get(User.class, 1);
        user1.setDepartment(department);
        mSession.update(user1);
    }

    @Test
    public void manyToOneDel(){
        Department department = mSession.get(Department.class, 2);
        mSession.delete(department);
    }


    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
