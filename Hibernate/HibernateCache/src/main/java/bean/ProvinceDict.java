package bean;

/**
 * Created by 尚振鸿 on 17-11-11. 17:05
 * mail:szh@codekong.cn
 */

public class ProvinceDict {
    //省份编号
    private String code;
    //省份名称
    private String name;

    public ProvinceDict() {
    }

    public ProvinceDict(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProvinceDict{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
