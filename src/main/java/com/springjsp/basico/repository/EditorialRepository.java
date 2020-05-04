package com.springjsp.basico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjsp.basico.entity.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

}
