package com.project.tetolicio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	
	public Optional<Baby> getBaby(Integer id) {
		
		Optional<Baby> b = babyRepo.findById(id);
		System.out.println("Heeyyyyy: " + b.get().getName());
		
		return b;
	}
	
	public Optional<Baby> getBabyByName(String name) {
		
		Baby b = new Baby();
		b.setName(name);
		Example<Baby> example = Example.of(b);
		Optional<Baby> ret = babyRepo.findOne(example);

		System.out.println("Heeyyyyy: " + ret.get().getName());
		
		return ret;
	}
}
