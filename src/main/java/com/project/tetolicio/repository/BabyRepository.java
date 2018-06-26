package com.project.tetolicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.tetolicio.model.Baby;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Integer> {

	/*
	@Query("select u from Baby u where u.name like :name")
	List<Baby> findByNameEndsWith(@Param("name") String name);
	
	@Query("select u from Baby u where u.birth = ?1")
	List<Baby> findByBirth(Calendar birth);
	*/
}
