package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

//사용자가 요청 -> 응답(HTML 파일)
//@Controller

// 사용자가 요청 ->응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest";

    /*롬복 빌더 장점. 빌더패턴을 만들어야하는데 직접 만들어준다.
    * 빌더패턴 장점: 생성자 입력 순서를 지키지 않아도 된다.
    * 필드에 어떤 값이 들어가야하는지 몰라도 가능*/

    @GetMapping("/http/lombok")
    public String lombokTest() {
      //  Member m = new Member(1,"sarr","1234","email");
        Member m = Member.builder().username("sarr").password("1234").email("ssar@nate.com").build();
        System.out.println(TAG + "getter" + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "setter" + m.getUsername());


        return "lombok Test 완료";
    }

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
