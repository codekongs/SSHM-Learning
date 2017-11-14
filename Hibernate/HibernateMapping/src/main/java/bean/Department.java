package bean;

/**
 * Created by 尚振鸿 on 17-11-14. 22:24
 * mail:szh@codekong.cn
 */

public class Department {
    //部门编号
    private int code;
    //部门名称
    private String departname;

    public Department() {
    }

    public Department(String departname) {
        this.departname = departname;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "code=" + code +
                ", departname='" + departname + '\'' +
                '}';
    }
}
