package com.project.tetolicio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.tetolicio.model.Baby;
import com.project.tetolicio.repository.BabyRepository;

@Service
public class BabyService {
	
	@Autowired
	BabyRepository babyRepo;
	
	public Baby save(Baby b) {
		
		babyRepo.save(b);
		System.out.println("Heeyyyyy: " + b.getName());
		
		return b;
	}
	
	public List<Baby> getAll() {
		
		return babyRepo.findAll();
	}
	
	public void remove(Integer id) {
		
		babyRepo.deleteById(id);
		
		return;
	}
	

}
