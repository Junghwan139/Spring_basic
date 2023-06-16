package com.example.demo.Study.St4;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class St4_memberRequestDto {

    public Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime created_at;




}
