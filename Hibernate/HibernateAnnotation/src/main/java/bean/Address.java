package bean;

import javax.persistence.Embeddable;

/**
 * Created by 尚振鸿 on 17-11-14. 15:47
 * mail:szh@codekong.cn
 */

@Embeddable
public class Address {
    private String province;
    private String city;

    public Address() {
    }

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
