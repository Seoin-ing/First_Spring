package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


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

    @PutMapping("/member/{id}")
    public Member updatMember(@PathVariable Long id, @RequestBody Member member) {
        //TODO: process PUT request
        Member existing = memberRepository.findById(id).orElseThrow();
        existing.setName(member.getName());
        existing.setAge(member.getAge());
        return memberRepository.save(existing);
    }

    @DeleteMapping("/member/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
        return "삭제 완료";
    }
}