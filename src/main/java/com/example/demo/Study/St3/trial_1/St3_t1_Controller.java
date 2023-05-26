package com.example.demo.Study.St3.trial_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class St3_t1_Controller {

    @Autowired St3_t1_Service st3t1Se;



    @GetMapping("St3t1_home")
    public String St3t1_ho(){
        return "study/St3/trial_1/St3_t1_home";
    }


    @GetMapping("St3_t1_new")
    public String St3t1_ne(){
        return "study/St3/trial_1/St3_t1_home";
    }

    @GetMapping("St3_t1_list")
    public String St3t1_li(){
        return "study/St3/trial_1/St3_t1_home";
    }







}
