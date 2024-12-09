package com.library.lms.service;


import com.library.lms.entity.Member;
import com.library.lms.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public Optional<Member> getMemberByID(Integer id){
        return memberRepository.findById(id);
    }

    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }

}
