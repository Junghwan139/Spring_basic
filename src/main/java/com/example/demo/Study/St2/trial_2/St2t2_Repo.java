package com.example.demo.Study.St2.trial_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface St2t2_Repo extends JpaRepository<St2t2_member, Long> {
}
