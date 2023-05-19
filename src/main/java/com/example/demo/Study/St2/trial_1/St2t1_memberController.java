package com.example.demo.Study.St2.trial_1;

import com.example.demo.Study.St2.Main.St2_member;
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


    @GetMapping("S2t1_findall")
    public String S2t1_find(Model model){
        List<St2t1_member> members = s2t1mems.find();
        model.addAttribute("memberList",members);
        return"study/St2/t1/St2t1_member-list";
    }

    @GetMapping("s2t1_findOne")
    public String S2t1_findone(@RequestParam (value = "id")Long myid, Model model){
        St2t1_member member = s2t1mems.finda(myid);
        model.addAttribute("member",member);
        return"study/St2/t1/St2t1_member-detail";
    }




    @PostMapping("St2t1_form")
    public String St2t1_form(St2t1_member member, Model model){
        s2t1mems.create(member);
        model.addAttribute("member_registered",member);
        return "study/St2/t1/St2t1_member-register-again";
    }


    @PostMapping("S2t1_json")
    @ResponseBody
    public String S2t1_json(@RequestBody St2t1_member member){
        s2t1mems.create(member);
        return "ok";
    }









}
