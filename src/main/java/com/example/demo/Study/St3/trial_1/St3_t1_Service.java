package com.example.demo.Study.St3.trial_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class St3_t1_Service {


    @Autowired St3_t1_Repository st3t1Re;

    public void save(St3_t1_Member member){
        st3t1Re.save(member);
    }

    public List<St3_t1_Member> findAll(){
        List<St3_t1_Member> members = st3t1Re.findAll();
        return members;
    }

    public St3_t1_Member findOne(Long id){
        St3_t1_Member member = st3t1Re.findById(id).orElse(null);
        return member;
    }




}
