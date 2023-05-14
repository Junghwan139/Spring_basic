package com.example.demo.Study.St1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class St1_test5_form {

    @PostMapping("test5_form")
    @ResponseBody
    public void test5_form(@RequestParam(value = "name") String myname,
                           @RequestParam(value = "email") String myemail,
                           @RequestParam(value = "password") String mypssword){

        System.out.println("이름 : "+ myname);
        System.out.println("email : "+ myemail);
        System.out.println("password : "+ mypssword);

    }

    @PostMapping("test5_form_2")
    @ResponseBody
    public void test5_form_2(@RequestParam(value = "name") String myname,
                           @RequestParam(value = "email") String myemail,
                           @RequestParam(value = "password") String mypssword){

        System.out.println("이름 : "+ myname);
        System.out.println("email : "+ myemail);
        System.out.println("password : "+ mypssword);

        Param pa = new Param();
        pa.setName1(myname);
        pa.setEmail1(myemail);
        pa.setPassword1(mypssword);

        System.out.println(pa.getName1()+"s");
        System.out.println(pa.getEmail1()+"s");
        System.out.println(pa.getPassword1()+"s");

    }


    @PostMapping("test5_form_3")
    @ResponseBody
    public void test5_form_3(Param pa2){



        System.out.println("이름 : "+pa2.getName1());
        System.out.println("email : "+ pa2.getEmail1());
        System.out.println("password : "+ pa2.getPassword1());

    }

    public class Param{
       private String name1;
       private String email1;
       private String password1;

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }

        public String getEmail1() {
            return email1;
        }

        public void setEmail1(String email1) {
            this.email1 = email1;
        }

        public String getPassword1() {
            return password1;
        }

        public void setPassword1(String password1) {
            this.password1 = password1;
        }
    }


}
