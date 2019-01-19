package yt.ch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yt.ch.entity.VoteEvent;
import yt.ch.service.VoteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chhapp on 2019/1/16.
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "/vote",method= RequestMethod.GET)
    @ResponseBody
    public String vote(HttpServletRequest request,@RequestParam Integer[] params){
        String code = voteService.vote(request,params);
        return code;
    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<VoteEvent> getVoteEvent(){
        return voteService.findVoteEvent();
    }
}
