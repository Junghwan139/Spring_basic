package com.example.demo.Study.St2.trial_4;

import com.example.demo.Study.St2.trial_3.St2t3_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class St2t4_Service {

    @Autowired St2t4_Repo repo4;

    public void create(St2t4_member member){
        repo4.save(member);
    }



}
