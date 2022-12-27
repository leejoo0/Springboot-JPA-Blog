package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired  //의존성 주입
    private UserRepository userRepository;

    //http://localhost:8080/blog/dummy/join (요청)
    //http의 body에 해당 데이터를 가지고 요청
    @PostMapping("/dummy/join")
    public String join(User user){ //ke = value : public String join(String username, String password , String email){ //ke = value


        System.out.println("username :" +user.getUsername());
        System.out.println("password :" +user.getPassword());
        System.out.println("email :" +user.getEmail());
        System.out.println("id :" +user.getId());
        System.out.println("Role :" +user.getRole());
        System.out.println("createdate :" +user.getCreateDate());

        user.setRole(RoleType.USER);

        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

}
