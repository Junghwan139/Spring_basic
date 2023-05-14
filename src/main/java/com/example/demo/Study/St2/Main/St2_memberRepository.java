package com.example.demo.Study.St2.Main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface St2_memberRepository extends JpaRepository<St2_member, Long> {  //entity명과, pk 매개변수로 넣기

}
