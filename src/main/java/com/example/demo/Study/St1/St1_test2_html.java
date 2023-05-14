package com.example.demo.Study.St1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class St1_test2_html {

    @GetMapping("test2_1")
    public String test2_1(){
        return "st1_hello";
    }
}
