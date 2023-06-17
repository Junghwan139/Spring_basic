package com.example.demo.Study.St4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class St4_memberController {

    @Autowired St4_memberService st4MemberService;

    @PostMapping("st4_save")
    @ResponseBody
    public void st4_save(@RequestBody St4_memberRequestDto member){
        st4MemberService.st4_save(member);
    }

    @GetMapping("s4_delete")
    public String st4_del(@RequestParam (value = "id")Long myid){

        st4MemberService.st4_del(myid);
        return "ok";
    }





}
