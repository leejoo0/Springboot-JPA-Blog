package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//note 스프링 컨트롤러 작동
/*
스프링이 com.cos.blog 패키지 이하를 스캔해서 모든 파일을 메모리에 new하는것은 아님
특정 어노테이션이 붙어있는 클래스 파일들을 new 해서 IoC 스프링컨테이너에 관리.
 */

@RestController
public class blogControllerTest {

    @GetMapping("/test/hello")
    public String hello(){
        return "<h1>hello Spring boot </h1>";
    }
}
