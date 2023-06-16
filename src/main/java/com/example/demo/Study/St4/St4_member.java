package com.example.demo.Study.St4;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class St4_member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String password;

    @Column(length = 255)
    private LocalDateTime created_at;

    @Builder
    St4_member(String name, String email, String password, LocalDateTime created_at){

        this.name = name;
        this.email = email;
        this.password = password;
        this.created_at = created_at;


    }




}
