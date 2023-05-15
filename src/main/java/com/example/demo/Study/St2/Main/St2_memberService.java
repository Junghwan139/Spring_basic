package com.example.demo.Study.St2.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class St2_memberService {

    @Autowired
    private St2_memberRepository st2Repository;

    // DB에 저장하기 : dbsave() 함수를 호출하면 매개변수로 받은 st2Member를 .save함수를 통해서 DB에 저장
    public void dbsave(St2_member st2Member){
        st2Repository.save(st2Member);  //JPA 함수
    }

    // DB데이터 조회 : findall() 함수를 호출하면 List<St2_member> 객체를 신규로 생성해서 .findAll()함수를 통해 검색한 데이터를 반환
    public List<St2_member> findtest(){
        List<St2_member> members = st2Repository.findAll();
        return members;
    }


    public St2_member findby(Long id){
        St2_member member = st2Repository.findById(id).orElse(null);
        return member;
    }





}
