package yt.ch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import yt.ch.entity.Voter;

import javax.transaction.Transactional;

/**
 * Created by chhapp on 2019/1/16.
 */
public interface VoteRepository extends JpaRepository<Voter,Long> {
    Voter findByIp(String ip);
}
