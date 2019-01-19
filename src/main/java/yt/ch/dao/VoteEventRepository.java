package yt.ch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yt.ch.entity.VoteEvent;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chhapp on 2019/1/16.
 */
public interface VoteEventRepository extends JpaRepository<VoteEvent,Integer> {

    List<VoteEvent> findAll();
    @Modifying
    @Query(value = "UPDATE vote_event v set v.count=v.count+1 where v.id in :id",nativeQuery = true)
    @Transactional
    void updateEventCount(@Param(value = "id") Integer[] id);
}
