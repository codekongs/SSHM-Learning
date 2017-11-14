package bean;

/**
 * Created by 尚振鸿 on 17-11-14. 22:23
 * mail:szh@codekong.cn
 */

public class User {
    private int uid;
    private String username;
    private String password;
    private Department department;

    public User() {
    }

    public User(String username, String password, Department department) {
        this.username = username;
        this.password = password;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                '}';
    }
}
