package com.library.lms.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffID;

    private String position;
    private String shift;
    private String staff;

    @OneToOne
    @JoinColumn(name = "members_memberID", referencedColumnName = "memberID")
    private Member memberI;
}
