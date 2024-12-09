package com.library.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberID;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "extensionName")
    private String extensionName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Column(name = "memberType")
    private String memberType;

    @OneToMany(mappedBy = "memberI")
    private List<Attendance>attendances;

    @OneToMany(mappedBy = "memberI")
    private List<Borrow>borrows;


    public Member(int memberID, String lastName, String firstName, String middleName, String extensionName, String email, int phoneNumber, String memberType, List<Attendance> attendances, List<Borrow> borrows) {
        this.memberID = memberID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.extensionName = extensionName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.memberType = memberType;
        this.attendances = attendances;
        this.borrows = borrows;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public String getMemberType() {
        return memberType;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
