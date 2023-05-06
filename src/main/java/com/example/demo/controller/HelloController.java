package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 이게 하나의 웹 서버임
@Controller  // 스프링부트 웹서버 최앞단에서 url기준으로 서버의 리소스 어떤 데이터를 보여줄지 결정. url을 결정해주는 관문역할
public class HelloController {

    // http://localhost:8080/ hello로 요청시 hello메서드에서 처리
    // http는 국제 통신프로토콜이다. https는 s(secure) 보안이 강화된 통신 프로토콜
    // port란 한 ip내에 여러 프로그램을 구분짓는 단위(프로그램을 구분짓는 유일한 구분자) 집주소가 ip, 각 집의 방문이 port

    // data만을 return할 때는 ResponseBody를 사용한다. 화면을 안찾고 바로 데이터 리턴

    //클라이언트사이드렌더링(CSR)
    // data만을 return할 때는 ResponseBody를 사용한다.
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }


    //서버사이드렌더링(SSR)
    // jsp / thymeleaf같은 템플릿엔진을 사용하여 화면을 return할떄에는 responsebody를 사용하면 안된다.
    // 그리고 Model이라는 객체에 data를 담아 return xxx를 하여 xxxx.html파일로 데이터를 보낸다.
    @GetMapping("hello-thymeleaf")
    public String hello2(Model model){
        model.addAttribute("getdata","hello2 world");
        return "hello";  // 템플에 파일 있는지 찾음
    }

}
