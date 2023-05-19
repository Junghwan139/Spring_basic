package com.example.demo.Study.St2.trial_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class St2t2_Controller {

    @Autowired St2t2_Service svc;

    @GetMapping("St2t2_SaveAndFind")
    public String st2t2_sf(Model model)
    {
        List<St2t2_member> lst = svc.findaa();
        model.addAttribute("memberList",lst);
        return "study/St2/t2/St2t2_member-register";
    }

    @PostMapping("St2t2_find")
    public String st2t2_sf2(St2t2_member member,Model model){
        svc.create(member);

        List<St2t2_member> lst = svc.findaa();
        model.addAttribute("memberList",lst);
        return "study/St2/t2/St2t2_member-list";

    }


}
