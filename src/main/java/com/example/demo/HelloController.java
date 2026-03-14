package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HelloController {

    private final MemberRepository memberRepository;

    public HelloController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요 박서인!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "서인씨 잘가요!";
    }

    @GetMapping("/member/{name}")
    public Member getMemberByName(@PathVariable String name) {
        return new Member(name, 0);
    }

    @PostMapping("/member")
    public Member saveMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping("/members")
    public java.util.List<Member> getMembers() {
        return memberRepository.findAll();
    }
}