package com.example.demo.Study.St2.trial_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class St2t1_memberController {

    @Autowired
    private St2t1_memberService s2t1mems;

    @GetMapping("S2t1_register")
    public String S2t1_html(){
        return"study/St2/t1/St2t1_member-register";
    }


    @PostMapping("St2t1_form")
    public String St2t1_form(St2t1_member member, Model model){
        List<St2t1_member> list_mem = new ArrayList<>();
        int count = 3;
        for(int i =0; i<count;i++){
            member.setName(member.getName()+"t"+String.valueOf(i));
            member.setEmail(member.getEmail()+"t"+String.valueOf(i));
            member.setPassword(member.getPassword()+"t"+String.valueOf(i));
            list_mem.add(member);
            s2t1mems.create(member);
        }
        model.addAttribute("member_registered",list_mem);
        return "study/St2/t1/St2t1_member-register-again";
    }



    @PostMapping("S2t1_json")
    @ResponseBody
    public String S2t1_json(@RequestBody St2t1_member member){
        s2t1mems.create(member);
        return "ok";
    }


}
