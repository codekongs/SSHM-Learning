import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

import model.Student;


/**
 * Created by 尚振鸿 on 17-11-11. 10:06
 * mail:szh@codekong.cn
 */

public class BlobTest {
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
    public void testBlob() throws IOException {
        //获取图片文件
        File file = new File("/home/szh/test.png");
        //获取图片文件的输入流
        InputStream inputStream = new FileInputStream(file);
        //创建一个Blob对象
        Blob image = Hibernate.getLobCreator(mSession).createBlob(inputStream, inputStream.available());
        Student student = new Student(1, "李四", "男", new Date(), "上海", image);
        //保存对象
        mSession.save(student);
    }


    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
