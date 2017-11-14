package bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by 尚振鸿 on 17-11-14. 16:27
 * mail:szh@codekong.cn
 */

@Entity
@Table(name = "STUDENT")
public class Student {

    @EmbeddedId
    private StudentPK id;

    private String name;
    private String sex;
    private Address address;

    @Transient
    private String gf;

    public Student() {
    }

    public Student(StudentPK id, String name, String sex, Address address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public StudentPK getId() {
        return id;
    }

    public void setId(StudentPK id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

