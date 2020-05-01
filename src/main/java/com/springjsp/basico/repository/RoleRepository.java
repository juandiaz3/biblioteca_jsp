package com.springjsp.basico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjsp.basico.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
