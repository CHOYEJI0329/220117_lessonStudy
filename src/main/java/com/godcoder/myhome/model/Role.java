package com.godcoder.myhome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity // 모델값이라는 표시
@Data  // lombok 사용
public class Role {

    @Id  // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

}
