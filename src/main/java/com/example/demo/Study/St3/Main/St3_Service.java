package com.example.demo.Study.St3.Main;

import com.example.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class St3_Service {

    @Autowired St3_JpaRepository s3jr;
    @Autowired St3_MybatisRepository s3mr;

    public void saveMDB(St3_Member member){
        s3mr.save(member);
    }

    public void saveDB(St3_Member member){
        s3jr.save(member);
    }

    public List<St3_Member> findMAll(){

        List<St3_Member> members = s3mr.findAll();
        return members;
    }


    public List<St3_Member> findJAll(){

        List<St3_Member> members = s3jr.findAll();
        return members;
    }

    public St3_Member finddone(Long id){
        St3_Member member = s3mr.findById(id);
        return member;
    }


    public St3_Member findjone(Long id){
        St3_Member member = s3jr.findById(id).orElse(null);
        return member;
    }


    public void findupdate(St3_Member member,Long id){
        St3_Member member1 = s3jr.findById(id).orElse(null);  //조회 한 멤버정보
        member1.setName(member.getName());
        member1.setEmail(member.getEmail());
        member1.setPassword(member.getPassword());
        s3jr.save(member1);
    }




}
