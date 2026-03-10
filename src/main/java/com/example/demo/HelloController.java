package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요 서인씨!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "서인씨 잘가요!";
    }
    
}