package com.example.demo.Study.St3.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class St3_Controller {


    @Autowired St3_Service s3S;

    @PostMapping("St3_save")
    @ResponseBody
    public String st3_save(@RequestBody St3_Member member){

        s3S.saveMDB(member);
        return "ok";
    }


    @PostMapping("St3_Jsave")
    @ResponseBody
    public String st3_jsave(@RequestBody St3_Member member){

        s3S.saveDB(member);
        return "ok";
    }


    @GetMapping("St3_serchall")
    @ResponseBody
    public List<St3_Member> st3_seachall(){

        List<St3_Member> members = s3S.findMAll();
        return members;
    }

    @GetMapping("St3_serchone")
    @ResponseBody
    public St3_Member st3_seachone(@RequestParam (value ="id")Long myid){

        St3_Member member = s3S.finddone(myid);
        return member;
    }



    // 홈화면 요청
    @GetMapping("St3_home")
    public String st3_home(){
        return "study/St3/St3-home";
    }

    // 신규등록 화면 요청
    @GetMapping("St3_new")
    public String st3_new(){
        return "study/St3/St3-register";
    }

    // 신규등록 등록 요청
    @PostMapping("St3_new")
    public String st3_post_new(St3_Member member){
        st3_save(member);
        System.out.println("등록완료");
        return "study/St3/St3-home";
    }

    // 리스트 조회 요청
    @GetMapping("St3_list")
    public String st3_list(Model model){

        List<St3_Member> members = s3S.findJAll();
        model.addAttribute("memberList",members);
        return "study/St3/St3-list";
    }

    // 세부내용 조회 요청
    @GetMapping("St3_one")
    public String st3_one(@RequestParam(value = "id")Long myid,Model model){

        St3_Member member = s3S.finddone(myid);
        model.addAttribute("member",member);
        return "study/St3/St3-member-detail";
    }

    @PostMapping("St3_up")
    public String st3_up(@RequestParam(value = "id")Long myid,
                         @RequestParam(value = "name")String myname,
                         @RequestParam(value = "email")String myemail,
                         @RequestParam(value = "password")String mypasssword,
                         Model model){

        St3_Member member = new St3_Member();
        member.setName(myname);
        member.setEmail(myemail);
        member.setPassword(mypasssword);
        s3S.findupdate(member,myid);

        return "study/St3/St3-home";
    }

















}
