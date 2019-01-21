package yt.ch.entity;

import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chhapp on 2019/1/16.
 */
@Entity
@Table(name = "voter")
public class Voter implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String ip;
    @Column
    private Integer count;
    @Column
    private String name;
    @Column
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
