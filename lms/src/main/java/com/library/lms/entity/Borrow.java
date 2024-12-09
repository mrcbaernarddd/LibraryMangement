package com.library.lms.entity;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "borrows")
public class Borrow {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowID;

    private String field;
    private Date borrowDate;
    private Date dueDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "members_memberID")
    private Member memberI;


    @ManyToOne
    @JoinColumn(name = "books_bookID")
    private Book bookI;
}
