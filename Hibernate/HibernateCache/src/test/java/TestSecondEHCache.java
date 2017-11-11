import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.ProvinceDict;

/**
 * Created by 尚振鸿 on 17-11-11. 17:10
 * mail:szh@codekong.cn
 */

public class TestSecondEHCache {
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
        ProvinceDict provinceDict1 = new ProvinceDict("001", "江苏省");
        ProvinceDict provinceDict2 = new ProvinceDict("002", "浙江省");
        mSession.save(provinceDict1);
        mSession.save(provinceDict2);
    }

    @Test
    public void testSecondCache(){
        ProvinceDict provinceDict = mSession.get(ProvinceDict.class, "001");
        System.out.println(provinceDict);

        Session session2 = mSessionFactory.openSession();
        provinceDict = session2.get(ProvinceDict.class, "001");
        System.out.println(provinceDict);
    }



    @After
    public void after(){
        mTransaction.commit();
        mSessionFactory.close();
    }
}
