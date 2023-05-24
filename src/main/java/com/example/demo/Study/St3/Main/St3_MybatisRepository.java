package com.example.demo.Study.St3.Main;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface St3_MybatisRepository {

    void save(St3_Member member);
    List<St3_Member> findAll();
    St3_Member findById(Long id);

}
