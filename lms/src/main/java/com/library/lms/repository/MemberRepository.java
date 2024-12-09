package com.library.lms.repository;

import com.library.lms.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    //kung gusto mo gustom method lagay mo dits
}
