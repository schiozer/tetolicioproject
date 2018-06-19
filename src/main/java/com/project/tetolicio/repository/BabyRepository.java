package com.project.tetolicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.tetolicio.model.Baby;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Integer> {

}
