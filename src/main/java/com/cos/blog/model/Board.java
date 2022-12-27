package com.cos.blog.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob  //대용량 데이터 쓸 때 사용
    private String content; //섬머노트 라이브러리 <html> 태그가 섞여서 디자인 됨

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne  //many = Board , User = one 한명의 유저는 여러 게시글을 쓸 수 있다.
    @JoinColumn(name = "userId")
    private User user;  //데이터베이스는 object를 저장 할 수 없다. FK , 자바는 오브젝트 저장이 가능

   @CreationTimestamp
    private Timestamp createDate;




}
