package com.library.lms.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceID;

    @ManyToOne
    @JoinColumn(name = "memberID")
    private Member memberI;

    private Date date;
    private Time timeIn;
    private Time timeOut;
    private String purpose;
}
