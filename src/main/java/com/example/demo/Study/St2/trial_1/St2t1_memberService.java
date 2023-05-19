package com.example.demo.Study.St2.trial_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class St2t1_memberService {

    @Autowired
    private St2t1_memberRepository s1t1memRepo;

    public void create(St2t1_member member){
        s1t1memRepo.save(member);
    }

    public List<St2t1_member> find(){
       List<St2t1_member> s2t1member = s1t1memRepo.findAll();
       return s2t1member;
    }

    public St2t1_member finda(Long id){
        St2t1_member stmember = s1t1memRepo.findById(id).orElse(null);
        return stmember;
    }




}
