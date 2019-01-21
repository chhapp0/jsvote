package yt.ch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yt.ch.dao.VoteEventRepository;
import yt.ch.dao.VoterVoteRepository;
import yt.ch.entity.VoteEvent;
import yt.ch.entity.Voter;
import yt.ch.dao.VoteRepository;
import yt.ch.entity.VoterVote;
import yt.ch.service.VoteService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chhapp on 2019/1/16.
 */
@Service
public class VoteServiceImpl implements VoteService{
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private VoteEventRepository voteEventRepository;
    @Autowired
    private VoterVoteRepository voterVoteRepository;

    @Override
    public String vote(HttpServletRequest request,Integer[] params,String name,String tel) {
        if(params.length>100){
            return "100";
        }
        String ip = getClientIpAddr(request);
        Voter voter = voteRepository.findByIp(ip);
        if(null==voter){
            Voter newVoter = new Voter();
            newVoter.setIp(ip);
            newVoter.setCount(params.length);
            newVoter.setName(name);
            newVoter.setTel(tel);
            voteRepository.save(newVoter);
            Long vid = voteRepository.findByIp(ip).getId();
            List<VoterVote> voterVotes = new ArrayList<>();
            for(int i = 0 ; i<params.length;i++){
                VoterVote voterVote = new VoterVote();
                voterVote.setVid(vid);
                voterVote.setEid(params[i]);
                voterVotes.add(voterVote);
            }
            voteEventRepository.updateEventCount(params);
            voterVoteRepository.saveAll(voterVotes);
            return "200";
        }else {
            return "101";
        }
    }

    @Override
    public List<VoteEvent> findVoteEvent() {
        return voteEventRepository.findAll();
    }

    private String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
