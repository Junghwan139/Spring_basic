package com.example.demo.Study.St2.trial_4;

import com.example.demo.Study.St2.trial_3.St2t3_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@Controller
public class St2t4_Controller {


    @Autowired St2t4_Service svc4;

    @PostMapping("t4_save")
    @ResponseBody
    public String st2t4save(@RequestBody St2t4_member member){
        svc4.create(member);
        return "ok";
    }

    @GetMapping("st4_th")
    public String st4_th(@RequestParam(value = "id") String myid, Model model){

        return "St2t1_member-detail";

    }




}
