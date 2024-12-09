package com.library.lms.controller;


import com.library.lms.entity.Member;
import com.library.lms.service.MemberService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
    public Member addMember(@RequestBody Member member){
        Member saveMember = memberService.saveMember(member);
        return memberService.saveMember(member);
    }

    @GetMapping
    public List<Member> getAllMember(){
        return memberService.getAllMember();
    }
}
