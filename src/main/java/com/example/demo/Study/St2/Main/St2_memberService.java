package com.example.demo.Study.St2.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class St2_memberService {

    @Autowired
    private St2_memberRepository st2Repository;

    // db에 저장하기
    public void dbsave(St2_member st2Member){
        st2Repository.save(st2Member);  //JPA 함수
    }




}
