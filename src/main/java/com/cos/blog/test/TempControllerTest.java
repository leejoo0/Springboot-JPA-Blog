package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHome(){
        System.out.println("Temp/home");

        //파일리턴 기본경로 : src/main/resources/static
        //static 이하에는 정적파일만 저장 png , html 등 브라우저에서 인식 할 수 있는 파일
        //리턴명 : /home.html
       return "/home.html";
    }
    @GetMapping("/temp/jsp")
    public String tempjsp(){
        System.out.println("Temp/jsp");
//        yml 내 파일 경로
//        prefix: /WEB-INF/views/
//                suffix: .jsp
//        풀네임 :  /WEB-INF/views/home.jsp
        return "test";
    }

}
