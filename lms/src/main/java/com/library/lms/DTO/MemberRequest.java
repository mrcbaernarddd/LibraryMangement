package com.library.lms.DTO;

import com.library.lms.entity.Member;
import lombok.Data;


@Data
public class MemberRequest {
    private Member member;
    private StudentMemberRequest studentRequest;
    private StaffMemberRequest staffRequest;
}
