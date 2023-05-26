package com.example.demo.Study.St3.trial_1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface St3_t1_Repository extends JpaRepository<St3_t1_Member, Long> {
}
