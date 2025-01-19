package com.project.ssafy.repository;

import com.project.ssafy.entity.RoleRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRegisterRepository extends JpaRepository<RoleRegister, Long> {
}
