package com.example.demo.Study.St2.trial_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class St2t3_Controller {

    @Autowired St2t3_Service svc3;

    @PostMapping("st3_save")
    public String st3save(@RequestBody St2t3_member member){
        svc3.create(member);
        return "ok";
    }


    @GetMapping("st3_findAll")
    @ResponseBody
    public List<St2t3_member> st3find(){
        List<St2t3_member> mems = svc3.findAll();
        return mems;
    }


    @GetMapping("st3_findlist")
    public String st3findlist(Model model){
        List<St2t3_member> members = svc3.findAll();
        model.addAttribute("memberList",svc3.findAll());
        return "study/St2/t3/St2t3_member-list";
    }




    @PostMapping("st3_save2")
    public String st3save2(@RequestBody List<St2t3_member> members){
        for(St2t3_member a : members){
            svc3.create(a);
        }
        return "ok";
    }






}
