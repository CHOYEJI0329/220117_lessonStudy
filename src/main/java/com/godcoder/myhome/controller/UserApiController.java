package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.Board;
import com.godcoder.myhome.model.User;
import com.godcoder.myhome.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
class UserApiController {

    @Autowired
    private UserRepository repository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/user")
    List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<User> users = repository.findAll();
        if("query".equals(method)) {
            users = repository.findByUsernameQuery(text);
        }else if("nativeQuery".equals(method)) {
            users = repository.findByUsernameNativeQuery(text);
        }else if("querydsl".equals(method)){
//            QUser이 import 안돼서 이부분 안됨. querydsl부분
           /*QUser customer = Quser.customer;
            Predicate predicate = user.username.contains(text);

            userRepository.findAll(predicate);*/
        }else if("querydslCustom".equals(method)){
            users = repository.findByUsernameCustom(text);
        }else{
            users = repository.findAll();
        }
        return users;
    }
    // end::get-aggregate-root[]

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/user/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
//                    user.setTitle(newUser.getTitle());
//                    user.setContent(newUser.getContent());
                    user.setBoards(newUser.getBoards());
                    /* orphanRemoval 속성 주고 싶을 경우 윗 문장 주석 처리하고 여기 있는 두 문장 주석 풀어줌.
                    user.getBoards().clear();
                    user.getBoards().addAll(newUser.getBoards());*/
                    for(Board board : user.getBoards()) {
                        board.setUser(user);
                    }

                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}