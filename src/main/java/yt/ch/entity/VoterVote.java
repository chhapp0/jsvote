package yt.ch.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chhapp on 2019/1/17.
 */
@Entity
@Table(name = "voter_vote")
public class VoterVote implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long vid;
    @Column
    private Integer eid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}
