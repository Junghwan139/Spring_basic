package com.example.demo.Study.St1;

import com.example.demo.controller.GoodBye;
import com.example.demo.controller.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class St1_test6_json {

    @PostMapping("test6_json")
    @ResponseBody
    public void test6(@RequestBody Hello hello){

        System.out.println("이름 : "+hello.getName());
        System.out.println("email : "+ hello.getEmail());
        System.out.println("password : "+ hello.getPassword());


    }

    @PostMapping("test6_json_return")
    @ResponseBody
    public GoodBye test6_2(@RequestBody Hello h2){

        System.out.println("이름 : "+h2.getName());
        System.out.println("email : "+ h2.getEmail());
        System.out.println("password : "+ h2.getPassword());

        GoodBye gb1 = new GoodBye();

        gb1.setName(h2.getName());
        gb1.setEmail(h2.getEmail());

        System.out.println(gb1.getName()+"2222");
        System.out.println(gb1.getEmail()+"2222");

        return gb1;

    }

}
