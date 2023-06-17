package com.example.demo.Study.St4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
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
    public St4_member st4_one(Long id){
        return st4_memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    // Update
    public void st4_update(St4_memberRequestDto member){

        St4_member member1 = St4_member.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .created_at(LocalDateTime.now())
                .build();

        st4_memberRepository.save(member1);
    }


    // Delete
    public void st4_del(Long id){
        st4_memberRepository.delete(st4_memberRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }









}
