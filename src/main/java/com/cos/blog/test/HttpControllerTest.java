package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

//사용자가 요청 -> 응답(HTML 파일)
//@Controller

// 사용자가 요청 ->응답(Data)
@RestController
public class HttpControllerTest {
    //인터넷 브라우저 요청은 무조건 GET 요청만 할 수 있다.
    //http://localhost:8080/http/get (select)
    //http://localhost:8080/http/get?id=1&username=lee
    @GetMapping("/http/get")
    public  String getTest(Member m){ // ?id=1&username=lee&password=1234&email=ssar@nate.com
        return "get 요청: id=" + m.getId()+ ", username = "+ m.getUsername() +"," +m.getPassword()+",email = "+m.getEmail();
    }

    //http://localhost:8080/http/post (insert)
    @PostMapping("/http/post") //text/plan , application/json
    public  String postTest(@RequestBody Member m){ // MessageConverter(스프링부트)

        return "post요청 id=" + m.getId()+ ", username = "+ m.getUsername() +"," +m.getPassword()+",email = "+m.getEmail();
    }

    //http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public  String putTest(@RequestBody Member m ){
        return "put요청 id=" + m.getId()+ ", username = "+ m.getUsername() +"," +m.getPassword()+",email = "+m.getEmail();
    }

    //http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public  String deleteTest(){
        return "delete 요청";
    }



}
