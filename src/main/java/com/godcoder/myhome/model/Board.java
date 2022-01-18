package com.godcoder.myhome.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // 모델값이라는 표시
@Data  // lombok 사용
public class Board {

    @Id  // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 이고 30자 이하입니다.")
    private String title;
    private String content;



}
