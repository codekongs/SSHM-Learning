package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 尚振鸿 on 17-11-14. 15:46
 * mail:szh@codekong.cn
 */

@Entity
@Table(name = "USER2")
public class User {
    private long uid;
    //用户名
    private String username;
    //密码
    private String password;
    //地址
    private Address address;
    public User() {
    }

    public User(long uid, String username, String password, Address address) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    @Id
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
