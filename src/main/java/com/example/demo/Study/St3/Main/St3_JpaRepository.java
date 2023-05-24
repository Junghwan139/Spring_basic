package com.example.demo.Study.St3.Main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface St3_JpaRepository extends JpaRepository<St3_Member, Long> {

}
