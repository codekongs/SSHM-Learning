package bean;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

/**
 * Created by 尚振鸿 on 17-11-14. 16:28
 * mail:szh@codekong.cn
 */

public class StudentPK implements Serializable{
    //学号
    @GeneratedValue()
    private long sid;

    //身份证号
    @GenericGenerator(name = "custom", strategy = "assign")
    @GeneratedValue(generator = "custom")
    @Column(length = 18)
    private String cardId;

    public StudentPK() {
    }

    public StudentPK(String cardId) {
        this.cardId = cardId;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
