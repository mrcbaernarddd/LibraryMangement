package com.library.lms.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentMemberRequest {

    private int memberID;
    private String lastName;
    private String firstName;
    private String middleName;
    private String extensionName;
    private String email;
    private String phoneNumber;
    private String memberType;

    //fields if member is student
    private int schoolStudentID;
    private String course;
    private int yearLevel;
    private String department;


}
