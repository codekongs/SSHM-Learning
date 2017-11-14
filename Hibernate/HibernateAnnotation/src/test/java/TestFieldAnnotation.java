import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Address;
import bean.Student;
import bean.StudentPK;

/**
 * Created by 尚振鸿 on 17-11-14. 15:56
 * mail:szh@codekong.cn
 */

public class TestFieldAnnotation {
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
    public void fieldAnnotationTest(){
        System.out.println("Test...");
        StudentPK studentPK = new StudentPK("123456789012345678");
        Address address = new Address("江苏省", "常州市");
        Student student = new Student(studentPK, "小红", "男", address);
        mSession.save(student);
    }

    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
