package com.example.demo.Study.St2.trial_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class St2t3_Service {

    @Autowired St2t3_Repo repo3;

    public void create(St2t3_member member){
        repo3.save(member);
    }


    public List<St2t3_member> findAll(){
        List<St2t3_member> members = repo3.findAll();
        return members;
    }




}
