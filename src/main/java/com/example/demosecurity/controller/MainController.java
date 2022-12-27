package com.example.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/login")
    public String loginPage(Model model) {

        return "loginUser";
    }

    @GetMapping(value = {"/", "/home"})
    public String HomeView(){
        return "home";
    }

    @GetMapping("/admin")
    public String AdminPage(){
        return "admin";
    }

    @GetMapping("/userInfo")
    public String userInfo(){
        return "userinfo";
    }
}
