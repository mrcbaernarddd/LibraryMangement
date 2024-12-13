package com.library.lms.repository;


import com.library.lms.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    // Define a method to find a student by member ID
    @Query("SELECT s FROM Student s WHERE s.member.memberID = :memberID")
    Students findByMemberId(@Param("memberID") Integer memberID);
}
