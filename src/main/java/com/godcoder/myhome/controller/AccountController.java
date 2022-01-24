package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.User;
import com.godcoder.myhome.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/login")
    public String login(){

        return "account/login";
    }

    @GetMapping("/register")
    public String register(){

        return "account/register";
    }

    @PostMapping("/register")
    public String register(User user){

        userServices.save(user);

        return "redirect:/";
    }



}
