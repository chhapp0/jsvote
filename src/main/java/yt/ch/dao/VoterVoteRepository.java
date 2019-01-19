package yt.ch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yt.ch.entity.VoterVote;

/**
 * Created by chhapp on 2019/1/17.
 */
public interface VoterVoteRepository extends JpaRepository<VoterVote,Long>{
}
