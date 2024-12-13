package com.library.lms.service;


import com.library.lms.DTO.StaffMemberRequest;
import com.library.lms.DTO.StudentMemberRequest;
import com.library.lms.entity.Member;
import com.library.lms.entity.Staff;
import com.library.lms.entity.Students;
import com.library.lms.repository.MemberRepository;
import com.library.lms.repository.StaffRepository;
import com.library.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final StudentRepository studentRepository;
    private final StaffRepository staffRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, StudentRepository studentRepository, StaffRepository staffRepository){
        this.memberRepository = memberRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
    }

    public Member saveMember(Member member, Object memberRequest){
        //member
        member.setFirstName(member.getFirstName());
        member.setLastName(member.getLastName());
        member.setMiddleName(member.getMiddleName());
        member.setExtensionName(member.getExtensionName());
        member.setEmail(member.getEmail());
        member.setPhoneNumber(member.getPhoneNumber());
        member.setMemberType(member.getMemberType());
        Member savedMember = memberRepository.save(member);

        //if student
        if (member.getMemberType().equalsIgnoreCase("student")){
            if (memberRequest instanceof StudentMemberRequest studentRequest) {
                Students student = new Students();

                student.setMemberI(member);
                student.setSchoolStudentID(studentRequest.getSchoolStudentID());
                student.setCourse(studentRequest.getCourse());
                student.setYearLevel(studentRequest.getYearLevel());

                studentRepository.save(student);
            }
            else {
                throw new IllegalArgumentException("Invalid request type for student.");
            }
        } else if (member.getMemberType().equalsIgnoreCase("staff")) {
            if (memberRequest instanceof StaffMemberRequest staffRequest){
                Staff staff = new Staff();

                staff.setMemberI(member);
                staff.setPosition(staffRequest.getPosition());
                staff.setShift(staffRequest.getShift());
                staff.setStaffStatus(staff.getStaffStatus());

                staffRepository.save(staff);
            }
        }

        return  savedMember;
    }

    public Optional<Member> getMemberByID(Integer id){
        return memberRepository.findById(id).map(member -> {
            if (member.getMemberType().equalsIgnoreCase("student") && member.getStudent() != null){
                member.setStudent(studentRepository.findByMemberId(member.getMemberID()));
            } else if (member.getMemberType().equalsIgnoreCase("staff")) {
                member.setStaff(staffRepository.findMemberId(member.getMemberID()));
            }
            return member;
        });
    }

    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }

}
