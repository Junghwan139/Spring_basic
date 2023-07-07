package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MemberJsonController {

    @Autowired
    private MemberService memeberService;


    @PostMapping("json/members/new")
    @ResponseBody
    public String memberCreateForm(@RequestParam(value="name") String myname,
                                   @RequestParam(value="email") String myemail,
                                   @RequestParam(value="password") String mypassword) throws SQLException {

        Member member1 = new Member();
        member1.setName(myname);
        member1.setEmail(myemail);
        member1.setPassword(mypassword);
        memeberService.create(member1);

        return "ok";


    }

    @GetMapping("json/members")
    @ResponseBody
    public List<Member> memberFindAll() throws SQLException {

        List<Member> members = memeberService.findAll();
        return members;


    }

    @GetMapping("json/member")
    @ResponseBody
    public Member memberFindid(@RequestParam(value = "id")Long id) throws SQLException {

        Member member = memeberService.findid(id);
        return member;

    }





}
