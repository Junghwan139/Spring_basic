package com.example.demo.Study.St2.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class St2_memberController {


    @Autowired
    St2_memberService st2MemberService;

    // jason타입으로 저장
    @PostMapping("s2save_jason")
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




}
