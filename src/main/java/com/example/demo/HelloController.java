package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Member;


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
    
    @GetMapping("/member")
    public Member getMember() {
        return new Member("박서인", 27);
    }
    
    @GetMapping("/member/{name}")
    public Member getMemberByName(@PathVariable String name) {
        return new Member(name, 0);
    }
}