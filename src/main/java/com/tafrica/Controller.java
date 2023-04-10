package com.tafrica;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("")
    public String showHomePage(){
       // System.out.println("Controller!!");
        return "index";
    }
}
