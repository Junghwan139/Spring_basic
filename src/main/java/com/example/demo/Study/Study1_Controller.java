package com.example.demo.Study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Study1_Controller {

//    <GET>

    // 1. 데이터만 넘겨주는 경우
    @GetMapping("test1")
    @ResponseBody
    public String test1(){
        return "hello";
    }

    // 2. 화면만 넘겨주는 경우
    @GetMapping("test2")
    public String test2(){
        return "St1_hello";
    }

    // 3. 화면에 데이터를 포함해서 넘겨주는 경우
    // Model class를 통하여 데이터를 같이 넘겨줌
    @GetMapping("test3_th")
    public String test3_thymleaf (Model model){
        model.addAttribute("getdata","test3_thymeleaf");
        return "hello-th";
    }

    //4. Get에 Parameter 처리
    @GetMapping("test4_pa")
    @ResponseBody
    public void test4_pa(@RequestParam(value = "name")String test4_va){
        System.out.println("당신의 이름은 : "+test4_va);
    }

//    <POST>

//    1-1. Form을 사용 하는 방법

    @GetMapping("test5_get_post")
    public String test5(){
        return "St1-post-form-req2";
    }

    @PostMapping("St1-post-form-req")  //넘겨 받는 주소
    public void test5_post(@RequestParam(value="name")String myname,
                           @RequestParam(value="email")String myemail,
                           @RequestParam(value="password")String mypassword
                           ){
        System.out.println("이름 : "+myname);
        System.out.println("email : "+myemail);
        System.out.println("Password : "+mypassword);
        System.out.println("test5_1");
    }

    //    1-2. Form을 사용 하는 방법(별도 class 사용)
    @PostMapping("St1-post-form-req2")
    public void test5_2_post(St1_hello hello)
    {
        System.out.println("이름 : "+hello.getName());
        System.out.println("email : "+hello.getEmail());
        System.out.println("Password : "+hello.getPassword());
        System.out.println("test5_2");
    }




//    2. jason을 사용 하는 방법
    @GetMapping("test6_js")
    public String test6(){
        return "St1-post-json-req";
    }

    @PostMapping("test6_js_2")
    @ResponseBody
    public void test6_js(@RequestBody St1_hello hello){
        System.out.println("이름 : "+hello.getName()+"이메일 : "+hello.getEmail()+"password"+hello.getPassword());
    }




}
