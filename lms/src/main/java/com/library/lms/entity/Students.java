package com.library.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
@Table(name = "students")
public class Students {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column(name = "schoolStudentID")
    private int schoolStudentID;

    @Column(name = "course")
    private String course;

    @Column(name = "yearLevel")
    private int yearLevel;

    @Column(name = "department")
    private String department;

    @OneToOne
    @JoinColumn(name = "members_memberID", referencedColumnName = "memberID")
    private Member memberI;
}
