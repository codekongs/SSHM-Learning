package model;

import java.sql.Blob;
import java.util.Date;

/**
 * Created by 尚振鸿 on 17-11-7. 19:58
 * mail:szh@codekong.cn
 */

public class Student {
    private int sid;// 学号
    private String sname;// 姓名
    private String gender;// 性别
    private Date birthday;// 出生日期
    private String address;// 地址
    private Blob image;//头像

    public Student() {
    }

    public Student(int sid, String sname, String gender, Date birthday, String address, Blob image) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.image = image;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", image=" + image +
                '}';
    }
}
