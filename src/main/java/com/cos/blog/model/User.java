package com.cos.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;

//ORM -> java(다른언어) Object -> 테이블로 매핑 해주는 기술

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @DynamicInsert //insert 할 때 null인 필드를 제외
@Entity
//Userclass가 Mysql에 테이블이 생성이 된다.
public class User {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 프로젝트에서 연결 된 데이터베이스 넘버링 전략을 따라간다는 뜻.
    private int id; // 시퀀스 , auto_increment

    @Column(nullable = false,length = 30) //null 안됨 길이 설정
    private String username; // 아이디

    @Column(nullable = false,length = 100) // 해쉬 사용해서 비밀번호 암호화
    private String password;

    @Column(nullable = false,length = 50)
    private String email;


    //DB는 roleType 없음
    @Enumerated(EnumType.STRING)
    private RoleType role;
//    @ColumnDefault("'user'")
//    private String role; //Enum 을 쓰는게 좋음 //admin , user , manager(managerrrr)
    //Enum을 쓰면 도메인 (범위를 설정 할 수 있음)

    @CreationTimestamp //시간이 자동입력 됨.
    private Timestamp createDate;


}
