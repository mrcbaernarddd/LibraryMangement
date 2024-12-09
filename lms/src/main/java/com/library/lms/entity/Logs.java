package com.library.lms.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "logs")
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logID;

    private String actionType;
    private Date actionDate;

    @ManyToOne
    @JoinColumn(name = "members_memberID")
    private Member memberI;
}
