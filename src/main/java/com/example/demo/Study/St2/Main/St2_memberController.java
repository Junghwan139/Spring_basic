package com.example.demo.Study.St2.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class St2_memberController {


    @Autowired
    St2_memberService st2MemberService;


    // json타입으로 저장
    @PostMapping("s2save_json")
    @ResponseBody
    public String st2test_j(@RequestBody St2_member member){
        st2MemberService.dbsave(member);
        return "ok";
    }

    // form타입으로 저장
    @PostMapping("s2save_form")
    @ResponseBody
    public String st2test_f(@RequestParam(value="name")String myname,
                            @RequestParam(value="email")String myemail,
                            @RequestParam(value="password")String mypassword
                            ){
        St2_member member2 = new St2_member();
        member2.setName(myname);
        member2.setEmail(myemail);
        member2.setPassword(mypassword);
        st2MemberService.dbsave(member2);
        return "ok";
    }

    //DB입력 데이터 조회 : json으로 전체 출력
    @GetMapping("returnData")
    @ResponseBody
    public List<St2_member> st2test_re(){
        List<St2_member> members = st2MemberService.findtest();
        return members;
    }

    //DB입력 데이터 조회 : json으로 1건 출력
    @GetMapping("findone")
    @ResponseBody
    public St2_member st2test_one(@RequestParam (value = "id")Long myid){
        St2_member member = st2MemberService.findby(myid);
        return member;
    }

    // DB등록을 위한 화면 요청
    @GetMapping("register")
    public String st2test_html(){
        return "study/St2/St2_member-register";
    }

    // DB등록을 위한 화면 요청 → form타입으로 저장
    @PostMapping("register")
    @ResponseBody
    public String st2test_j2(St2_member member){

        st2MemberService.dbsave(member);
        return "ok";
    }

    //thymleaf로 반환
    @GetMapping("thymleafs")
    public String st2test_th(Model model){
        List<St2_member> members = st2MemberService.findtest();
        model.addAttribute("memberList",members);
        return "study/St2/St2_member-list";
    }

    //thymleaf로 반환 한 데이터 중 id값에 맞는 데이터만 detail 보기
    @GetMapping("thymleaf")
    public String st2test_th2(@RequestParam (value = "id")Long myid, Model model){
        St2_member member = st2MemberService.findby(myid);
        model.addAttribute("member",member);
        return "study/St2/St2_member-detail";
    }





}
