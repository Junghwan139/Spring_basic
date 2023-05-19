package com.example.demo.Study.St2.trial_3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface St2t3_Repo extends JpaRepository<St2t3_member, Long> {
}
