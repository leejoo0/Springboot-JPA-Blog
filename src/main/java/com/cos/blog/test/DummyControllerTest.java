package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

//html 파일이 아니라 data를 리턴 해 주는 컨트롤러 = ResrController
@RestController
public class DummyControllerTest {

    @Autowired  //의존성 주입
    private UserRepository userRepository;


    //save함수는 id를 전달하지 않으면 insert를 해주고
    //save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
    //save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해준다.
    //http://localhost:8000/blog/dummy/user/3
    @Transactional  //함수 종료시에 자동 커밋이 됨.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User requestUser){ //json 데이터를 요청했는데 java object (Messageconverter 의 jackson라이브러리가 변환해서 받아줌
        System.out.println("id :" +id);
        System.out.println("pw :" + requestUser.getPassword());
        System.out.println("email :" + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
           return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

//        userRepository.save(user);

        //더티 체킹
        return null;
    }

    //http://localhost:8000/blog/dummy/users
    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    //http://localhost:8000/blog/dummy/user?page=1
    //.getContent(); 사용하면 List 형태로 리턴 가능
    // 리스트 형태로 받아서 별도의 처리를 해주는게 유용하다.

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUsers = userRepository.findAll(pageable);
        List<User> users = pagingUsers.getContent();

        return users;
    };

    //{id} 주소로 파라메터를 전달 받을 수 있음.
    //http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        //user/4 를 찾았을 때 데이터베이스에서 못찾아오면 null 이 되니까 프로그램에 문제 있음
        //Optional로 user 객체를 감싸서 가져올테니 직접 null인지 판단해!!
        // .get 은 null 이 나올리가 없어.   .orElseGet   //인터페이스는 new 할 수 없음. 익명 클래스를 만들어야함
//        userRepository.findById(id).orElseGet(new Supplier<User>() {
//            @Override
//            public User get() {
//                return new User();
//            }
//        });
        //findById(id) 내부 던지기 확인

        //람다식 :
        // User user = userRepository.findById(id).orElseThrow(()->{
        // return new IllegalArgumentException("해당 유저는 없습니다. id : "+ id);
        // });
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : "+ id);
            }
        });
        //user 객페 = 자바 오브젝트 , 요청은 웹브라우저
        //변환 (웹브라우저가 이해 할 수 있는 데이터) -> json (Gson 라이브러리)
        //스프링부트 = MessageConverter 라는 애가 응답시에 자동 작동
        //만약에 자바 오브젝트를 리턴하게 되면 MessageConverter Jackson 라이브러리를 호출해서
        //user 오브젝트를 json으로 변환해서 브라우저에게 던져줌.
        return user;
    }

    //http://localhost:8000/blog/dummy/join (요청)
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
