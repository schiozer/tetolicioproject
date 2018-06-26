package com.project.tetolicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.tetolicio.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
