package com.example.demo.Study.St4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class St4_memberService {


    @Autowired St4_memberRepository st4_memberRepository;

    // Create
    public void st4_save(St4_memberRequestDto member){

        St4_member member1 = St4_member.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .created_at(LocalDateTime.now())
                .build();

        st4_memberRepository.save(member1);

    }

    // Read_all

    public List<St4_member> st4_findall(){

        return st4_memberRepository.findAll();
    }

    // Read_one
    


    // Update


    // Delete








}
