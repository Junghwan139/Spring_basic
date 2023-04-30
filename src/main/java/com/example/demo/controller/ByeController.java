package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ByeController {

    @GetMapping("bye")
    @ResponseBody
    public String bye(){
        return "bye world";
    }






}
