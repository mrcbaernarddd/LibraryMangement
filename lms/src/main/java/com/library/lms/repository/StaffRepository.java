package com.library.lms.repository;


import com.library.lms.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    @Query("SELECT s FROM Staff s WHERE s.member.memberID = memberID")
    Staff findMemberId(@Param("memberID")Integer memberID);
}
