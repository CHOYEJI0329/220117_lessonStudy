package com.godcoder.myhome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // 모델값이라는 표시
@Getter  // lombok 사용
@Setter
public class Board {

    @Id  // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 이고 30자 이하입니다.")
    private String title;
    private String content;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


}
