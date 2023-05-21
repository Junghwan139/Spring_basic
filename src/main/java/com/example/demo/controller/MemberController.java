package com.example.demo.controller;


import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MemberController {

// MemberService를 주입
// Postmapping를 통해 MemberService 호출하는 method

    @Autowired
    private MemberService memeberService;


    @GetMapping("/")
    public String tohome(){
        return "member/member-home";
    }


    @PostMapping("member/update")
    public String memberUpdate(@RequestParam(value="id") String myid,
                               @RequestParam(value="name") String myname,
                               @RequestParam(value="email") String myemail,
                               @RequestParam(value="password") String mypassword) throws Exception {

        Member member1 = new Member();
        member1.setId(Long.parseLong(myid));
        member1.setName(myname);
        member1.setEmail(myemail);
        member1.setPassword(mypassword);
        memeberService.update(member1, member1.getId());

        return "redirect:/";

    }




        @GetMapping("members/new")
    public String memberCreateFrom() {

        return "member/member-register";

    }


    @PostMapping("members/new")
    public String memberCreateForm(@RequestParam(value="name") String myname,
                               @RequestParam(value="email") String myemail,
                               @RequestParam(value="password") String mypassword) throws SQLException {

        Member member1 = new Member();
        member1.setName(myname);
        member1.setEmail(myemail);
        member1.setPassword(mypassword);
        memeberService.create(member1);

//        member는 class를 new하여 객체를 만드는 반면에
//        memberService는 객체를 만들지 않고, 바로 사용하고 있다.
//        이틑 MemberService는 component를 통해 싱글톤으로 만들어져 있기 때문
//        싱글톤으로 만들어진 Component는 객체를 생성하는 것이 아니라 주입(DI)를 받아 사용

        return "redirect:/";


    }





    @PostMapping("members")
    @ResponseBody

    //input 값을 form데이터로 받는 방식
    public String memberCreate(@RequestParam(value="name") String myname,
                               @RequestParam(value="email") String myemail,
                               @RequestParam(value="password") String mypassword) throws SQLException {

        // Memeber 객체를 만들어서 MemberService 매개변수로 전달
        Member member1 = new Member();
        member1.setName(myname);
        member1.setEmail(myemail);
        member1.setPassword(mypassword);
        memeberService.create(member1);

        /*
        // json으로 받는 방법
        public String memberCreate(@Requestbody Member member) {

            // Memeber 객체를 만들어서 MemberService 매개변수로 전달
            Member member1 = new Member();
            member1.setName(member.getname());
            member1.setEmail(member.getemail);
            member1.setPassword(member.getpassword);
            memeberService.create(member1);

        */

            return "ok";


    }

/*

    @GetMapping("members")
    @ResponseBody
    public List<Member> memberFindAll() {

        List<Member> members = memeberService.findAll();
        return members;

    }

*/

    @GetMapping("members")
    public String memberFindAll(Model model) throws SQLException {   //타서버 조회시 강제시킴

        List<Member> members = memeberService.findAll();
        model.addAttribute("memberList",members);
        return "member/member-list";

    }




/*

    @GetMapping("members/detail")
    @ResponseBody
    public Member memberFinddetail(@RequestParam(value = "id")Long id) {

        Member member = memeberService.findid(id);
        return member;

    }
*/


/*

    @GetMapping("member")
    @ResponseBody
    public Member memberFindid(@RequestParam(value = "id")Long id) {

        Member member = memeberService.findid(id);
        return member;

    }

*/

    @GetMapping("member")
    public String memberFindid(@RequestParam(value = "id")Long id,Model model) throws SQLException {

        Member member = memeberService.findid(id);
        model.addAttribute("member",member);

        return "member/member-detail";

    }


}