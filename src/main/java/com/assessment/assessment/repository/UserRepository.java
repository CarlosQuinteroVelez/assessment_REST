package com.assessment.assessment.repository;

import com.assessment.assessment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    boolean existsByName(String name);

    boolean existsById(long id);





}
