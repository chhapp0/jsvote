package yt.ch.service;

import yt.ch.entity.VoteEvent;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chhapp on 2019/1/16.
 */
public interface VoteService {
    String vote(HttpServletRequest request,Integer[] params,String name,String tel);
    List<VoteEvent> findVoteEvent();
}
