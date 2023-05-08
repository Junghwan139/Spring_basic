package com.example.demo.Study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class St1_test4_get_param {

    @GetMapping("st4_test4")
    public String test4_2(@RequestParam(value = "id")String myid){
        System.out.println(myid);
        return "st1_hello";
    }

}
