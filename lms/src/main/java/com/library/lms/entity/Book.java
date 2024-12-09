package com.library.lms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    private String title;
    private String author;
    private String category;
    private boolean available;

    @OneToMany
    private List<Borrow> borrows;
}
