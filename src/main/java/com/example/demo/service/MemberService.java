package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberJdbcRepository;
import com.example.demo.repository.MemberMybatisRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MemberService {


// service에서 repository를 주입 받기 위해서, Autowired를 사용(다른 방법도 있음)
// springdatajpa를 사용한 repository
@Autowired
private MemberRepository memeberRepository;


// mybatis를 사용한 repository
// jpa와 함께 사용할 수도 있다. 복잡한 service logic또는 heavy한 쿼리가 있을경우
// jpa로는 한계가 있으므로, 현업에선느 mybatis와 jpa를 섞어 사용하기도 한다.
@Autowired
private MemberMybatisRepository memberMybatisRepository;

// JDBC 레파지토리
@Autowired
private MemberJdbcRepository memberJdbcRepository;

// 회원가입(등록)
public void create(Member member) throws SQLException {
    System.out.println("memberJdbcRepository test");
    memeberRepository.save(member);  // save함수는 선언 안했지만 jpa상속받아서 사용가능 save기능 insert

}

// 회원목록조회
// memeberRepository.findAll()의 기본 return 타입은 List<해당객체>

public List<Member> findAll() throws SQLException {

    List<Member> members = memeberRepository.findAll();
    return members;

}

public Member findid(Long id) throws SQLException {

Member member = memeberRepository.findById(id).orElse(null);  //optional 객체 확인
return member;

}


public void update(Member member, Long id) throws Exception {
    //save는 이미 존재하는 pk(id)이 있으면, update로 동작, id값이 없으면 insert로 동작
    Member member1 = memeberRepository.findById(member.getId()).orElse(null);
    if(member1==null){
        throw new Exception();
    }else{

        member1.setName(member.getName());
        member1.setEmail(member.getEmail());
        member1.setPassword(member.getPassword());
        memeberRepository.save(member1);

    }

}




}
