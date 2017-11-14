package bean;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by 尚振鸿 on 17-11-14. 20:08
 * mail:szh@codekong.cn
 */

@Entity
@Table(name = "GRADE")
public class Grade {

    @Id
    @GenericGenerator(name = "gid", strategy = "native")
    @GeneratedValue(generator = "gid")
    private int gid;

    //班级名称
    private String name;

    //班级描述
    private String gdesc;

    @JoinColumn(name = "gid")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Stu> stus = new HashSet<>();


    public Grade() {
    }

    public Grade(String name, String gdesc) {
        this.name = name;
        this.gdesc = gdesc;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public Set<Stu> getStus() {
        return stus;
    }

    public void setStus(Set<Stu> stus) {
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", gdesc='" + gdesc + '\'' +
                ", stus=" + stus +
                '}';
    }
}
