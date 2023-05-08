package com.example.demo.Study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class St1_test1_data {

    @GetMapping("test1_1")
    @ResponseBody
    public String test1(){
        return "test1_hello_world";
    }
}
