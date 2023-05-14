package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {


// service에서 repository를 주입 받기 위해서, Autowired를 사용(다른 방법도 있음)
@Autowired
private MemberRepository memeberRepository;

// 회원가입(등록)
public void create(Member member){
    memeberRepository.save(member);  // save함수는 선언 안했지만 jpa상속받아서 사용가능 save기능 insert

}

// 회원목록조회
// memeberRepository.findAll()의 기본 return 타입은 List<해당객체>

public List<Member> findAll(){

    List<Member> members = memeberRepository.findAll();
    return members;

}

public Member findid(Long id){

Member member = memeberRepository.findById(id).orElse(null);  //optional 객체 확인
return member;

}






}
