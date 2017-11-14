import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import bean.Grade;
import bean.Stu;

/**
 * Created by 尚振鸿 on 17-11-14. 20:24
 * mail:szh@codekong.cn
 */

public class TestOneToMany {

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
    public void oneToManyTest(){
        Grade grade = new Grade("物联一班", "我们是物联网一班");
        Stu stu1 = new Stu("小红", "男");
        Stu stu2 = new Stu("小白", "男");
        Set<Stu> stus = new HashSet<>();
        stus.add(stu1);
        stus.add(stu2);
        grade.setStus(stus);

        mSession.save(grade);

        mSession.flush();

        mSession.save(stu1);
        mSession.save(stu2);
    }

    @Test
    public void oneToManyGet(){
        Grade grade = mSession.get(Grade.class, 1);
        System.out.println(grade);

        Set<Stu> stus = grade.getStus();
        for (Stu stu : stus){
            System.out.println(stu);
        }
    }


    @Test
    public void oneToManyUpdate(){
        Stu stu = mSession.get(Stu.class, 1);
        Grade grade = new Grade("物联网二班", "这是物联网二班");
        Set<Stu> stus = new HashSet<>();
        stus.add(stu);
        grade.setStus(stus);
        mSession.save(grade);
    }

    @Test
    public void oneToManyDel(){
        Grade grade = mSession.get(Grade.class, 4);
        mSession.delete(grade);
    }


    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
