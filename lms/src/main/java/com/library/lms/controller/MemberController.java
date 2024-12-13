package com.library.lms.controller;


import com.library.lms.DTO.MemberRequest;
import com.library.lms.entity.Member;
import com.library.lms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Member addMember(@RequestBody MemberRequest memberRequest){

        Member member = memberRequest.getMember();

        if ("student".equalsIgnoreCase(member.getMemberType())){
            return memberService.saveMember(member, memberRequest.getStudentRequest());
        } else if ("staff".equalsIgnoreCase(member.getMemberType())) {
            return memberService.saveMember(member, memberRequest.getStaffRequest());
        } else {
            throw new IllegalArgumentException("Invalid member type.");
        }
    }

    @GetMapping
    public List<Member> getAllMember(){
        return memberService.getAllMember();
    }

    @GetMapping("/{id}")
    public MemberRequest getMemberByID(@PathVariable int id){
        return memberService.getMemberByID(id)
                .map(member -> {
                    MemberRequest memreq = new MemberRequest();
                    memreq.getMember().setMemberID(member.getMemberID());
                    memreq.getMember().setLastName(member.getLastName());
                    memreq.getMember().setFirstName(member.getFirstName());
                    memreq.getMember().setMemberType(member.getMemberType());

                    if ("student".equalsIgnoreCase(member.getMemberType())&& member.getStudent() != null){
                        memreq.getMember().getStudent().setSchoolStudentID(member.getStudent().getSchoolStudentID());
                        memreq.getMember().getStudent().setCourse(member.getStudent().getCourse());
                        memreq.getMember().getStudent().setYearLevel(member.getStudent().getYearLevel());
                        memreq.getMember().getStudent().setDepartment(member.getStudent().getDepartment());
                    } else if ("staff".equalsIgnoreCase(member.getMemberType()) && member.getStaff() != null) {
                        memreq.getMember().getStaff().setPosition(member.getStaff().getPosition());
                        memreq.getMember().getStaff().setStaffStatus(member.getStaff().getStaffStatus());
                        memreq.getMember().getStaff().setShift(member.getStaff().getShift());
                    }
                    return memreq;
                })
                .orElse(null);
    }
}
