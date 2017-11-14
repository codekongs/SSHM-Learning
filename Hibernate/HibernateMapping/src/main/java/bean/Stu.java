package bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 尚振鸿 on 17-11-14. 20:08
 * mail:szh@codekong.cn
 */
@Entity
@Table(name = "STU")
public class Stu {

    //学号
    @Id
    @GeneratedValue(generator = "sid")
    @GenericGenerator(name = "sid", strategy = "native")
    private int sid;

    //姓名
    @Column(length = 8)
    private String name;

    //性别
    @Column(length = 2)
    private String sex;

    public Stu() {
    }

    public Stu(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
