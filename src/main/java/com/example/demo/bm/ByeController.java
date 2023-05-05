package com.example.demo.bm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ByeController {

    @GetMapping("bye")
    @ResponseBody
    public String bye(){
        return "bye world";
    }


    @GetMapping("bye-test1")
    public String bye_test(Model model){
        model.addAttribute("getdata","byebye22");

        return "goodbye"; // templates내에서 "goodbye" html을 찾는다
    }





}
