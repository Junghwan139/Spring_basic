package com.example.demo.Study.St1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class St1_test3_th {

    @GetMapping("test3_2")
    public String test3_2(Model model){
        model.addAttribute("getdata", "test3_2_th");
        model.addAttribute("val_1","num1");
        model.addAttribute("val_2","num2");
        return "st1-th";

    }

}
