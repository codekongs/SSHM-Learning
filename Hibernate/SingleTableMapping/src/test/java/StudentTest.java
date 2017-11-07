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
 * Created by 尚振鸿 on 17-11-7. 20:16
 * mail:szh@codekong.cn
 */

public class StudentTest {
    private SessionFactory mSessionFactory;
    private Session mSession;
    private Transaction mTransaction;

    @Before
    public void before(){
        //创建会话工厂对象
        mSessionFactory = new Configuration().configure().buildSessionFactory();
        //创建会话
        mSession = mSessionFactory.openSession();
        //开启事务
        mTransaction = mSession.beginTransaction();
    }


    /*@Test
    public void testSave(){
        //生成学生对象
        Student student = new Student(1, "张三", "男", new Date(), "张家村");
        //保存对象到数据库
        mSession.save(student);
    }*/

    @Test
    public void autoCommitTransaction(){
        Student student = new Student(2, "张三", "男", new Date(), "张家村");
        //设置自动提交事务(不建议)
        mSession.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                connection.setAutoCommit(true);
            }
        });
        mSession.save(student);
        //强制输出SQL语句
        mSession.flush();
    }

/*
    @After
    public void after(){
        //提交事务
        mTransaction.commit();
        //关闭会话
        mSession.close();
        //关闭会话工厂
        mSessionFactory.close();
    }*/
}
