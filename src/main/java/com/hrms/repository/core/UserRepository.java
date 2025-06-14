package com.hrms.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {

}
