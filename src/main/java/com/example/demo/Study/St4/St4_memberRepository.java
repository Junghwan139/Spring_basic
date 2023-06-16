package com.example.demo.Study.St4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface St4_memberRepository extends JpaRepository<St4_member, Long> {
}
