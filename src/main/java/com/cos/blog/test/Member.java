package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
  // 전체 생성자
@NoArgsConstructor   // 빈 생성자

public class Member {

    //java에서 (객체지향) 변수는 private로 만든다. 변수의 상태는 메서드에 의해 변경이 되게 설계해야한다.
//   final 붙여서 불변성 유지. 수정 안되게 막음
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder   //빌더 패턴. 사용은 Member.builer 로 사용하고, id 증가값 만들기 등 가능
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
