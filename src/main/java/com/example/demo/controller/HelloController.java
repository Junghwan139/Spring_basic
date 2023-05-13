package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// 이게 하나의 웹 서버임
@Controller  // 스프링부트 웹서버 최앞단에서 url기준으로 서버의 리소스 어떤 데이터를 보여줄지 결정. url을 결정해주는 관문역할
public class HelloController {

    // http://localhost:8080/ hello로 요청시 hello메서드에서 처리
    // http는 국제 통신프로토콜이다. https는 s(secure) 보안이 강화된 통신 프로토콜
    // port란 한 ip내에 여러 프로그램을 구분짓는 단위(프로그램을 구분짓는 유일한 구분자) 집주소가 ip, 각 집의 방문이 port

    // data만을 return할 때는 ResponseBody를 사용한다. 화면을 안찾고 바로 데이터 리턴

    // data만을 return할 때는 ResponseBody를 사용한다.
    // 최근에 더 많이 사용하는 방법 (현대적인 방식)
    @GetMapping("hello")
    @ResponseBody
    public String hello() {return "hello world";
    }

    // jsp / thymeleaf같은 템플릿엔진을 사용하여 화면을 return할떄에는 responsebody를 사용하면 안된다.
    // 그리고 Model이라는 객체에 data를 담아 return xxx를 하여 xxxx.html파일로 데이터를 보낸다.
    // 화면을 렌더링 하는 방식
    @GetMapping("hello-thymeleaf")
    public String hello2(Model model){
        model.addAttribute("getdata","hello2 world");
        return "hello-th";  // 템플에 파일 있는지 찾음
    }

    // 데이터를 첨부시키지 않고, 화면만을 렌더링(준다) 할 수도 있다.
    // html단에서 동적인 javascript를 통해 가져오는 로직이 들어가야 함.
    @GetMapping("hello-html")
    public String helloHtml(){  //model은 데이터를 주입할 때 필요
        return "hello-get-req";  // 템플에 파일 있는지 찾음
    }
    
    //★test
    @GetMapping("hello-param")
    @ResponseBody
    public String helloParam(@RequestParam(value = "id")String id){
        System.out.println(id);
        return "ok";
    }
    
    @GetMapping("hello-post-form-req")
    public String helloGerFormReq(){
        return "hello-post-form-req";
    }

    // html의 form형식으로 post요청
    // form형식의 경우 parameter로 데이터가 넘어오므로, requestparam으로 받아줘야 한다.
    // parameter 방식? 클라이언트에서 서버로 주는 방식 파라미터 ??로 담아서
    @PostMapping("hello-post-form-req")
    @ResponseBody
    public String helloPostFormReq(@RequestParam(value="name") String myname,
                                 @RequestParam(value="email") String myemail,
                                 @RequestParam(value="password") String mypassword){

        System.out.println("이름 : "+myname);
        System.out.println("이메일 : "+myemail);
        System.out.println("비밀번호 : "+mypassword);

        return "ok";

    }


    // 테스트 할때에, localhost:8080/hello-parameter?test=hello
    @GetMapping("hello-parameter")
    @ResponseBody
    public String helloParameter(@RequestParam(value = "test")String mytest){
        System.out.println("클라이언트가 보내온 parameter는?"+mytest);
        return "ok";
    }





    //사용자가 서버로 데이터를 보내는 방식에는 총 3가지가 있다.
    // 1. ?를 통해 parameter 값을 넣어 보내는 방식 : 대부분 get요청시 서용
    // 2. form 태그 안에 data를 넣어 보내는 방식 : post요청시 사용
    //    (보안이 강화되고, url에 데이터가 찍히지 않는다. 그런데, 내부적으로는 ?key1 = value1 & key2 = value2의 형식을 취한다.) 따라서 requestparam을 써야함
    // 3. json 데이터 형식으로 서버로 보내는 방식 (requestbody를 씀) : post요청시 사용
    //    json 데이터란 {"key1":"value1", "key2":"value2"}의 형식을 취하는 데이터이다.
    //    현대적인 web서비스에서 대부분의 데이터를 주고 받을 때 json을 사용한다.
    //    json html의 form태그에 넣어서 보내는 방식이 아니다보니, Ajax, react 이런 javascript 프레임워크를 사용하게 된다.
    
    
    //json으로 post요청을 하기 우한 화면 return
    @GetMapping("hello-get-json-req")
    public String hellojsonFormReq(){
        return "hello-post-json-req";
    }
    
    //json으로 post요청이 들어 왔을때는 data를 꺼내기 위해 requestbody 사용
    @PostMapping("hello-json")
    @ResponseBody
    public String helloJson(@RequestBody Hello hello){

        System.out.println("이름 : "+hello.getName());
        System.out.println("이메일 : "+hello.getEmail());
        System.out.println("비밀번호 : "+hello.getPassword());

        return "ok";
    }

//    -----------------------------------------------------------------------------------------------------------

    // ResponseBody 어노테이션이 붙어 있고, return타입이 객체이면 spring이 json형태로 변환해준다.
    @PostMapping("hello-json-response")
    @ResponseBody
    public GoodBye helloJsonResponse(@RequestBody Hello hello){

        System.out.println("이름 : "+hello.getName());
        System.out.println("이메일 : "+hello.getEmail());
        System.out.println("비밀번호 : "+hello.getPassword());
        GoodBye goodbye1 = new GoodBye();
        goodbye1.setName(hello.getName());
        goodbye1.setEmail(hello.getEmail());
        goodbye1.setComments("thankyou");
        return goodbye1;   // @ResponseBody가 있으면 리턴타입 GoodBye 클래스를 json으로 변환
    }





}
