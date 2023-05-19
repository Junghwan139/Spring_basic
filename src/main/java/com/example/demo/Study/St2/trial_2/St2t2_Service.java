package com.example.demo.Study.St2.trial_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class St2t2_Service {

    @Autowired
    private St2t2_Repo S2t2_Repo;

    // DB에 저장하고 현잭까지 리스트를 반환
    public void create(St2t2_member member){
        S2t2_Repo.save(member);
    }

    public List<St2t2_member> findaa(){
        List<St2t2_member> members = S2t2_Repo.findAll();
        return members;
    }





}
