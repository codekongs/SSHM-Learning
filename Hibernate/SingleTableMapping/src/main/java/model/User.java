package model;

/**
 * Created by 尚振鸿 on 17-11-11. 10:27
 * mail:szh@codekong.cn
 */

public class User {
    //id
    private int uid;
    //用户名
    private String username;
    //密码
    private String password;
    //地址
    private Address address;

    public User() {
    }

    public User(String username, String password, Address address) {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
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

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
