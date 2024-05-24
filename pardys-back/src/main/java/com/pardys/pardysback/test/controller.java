package com.pardys.pardysback.test;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class controller {

    @PostMapping("")
    public String test(){
        return "hello world";
    }
}
