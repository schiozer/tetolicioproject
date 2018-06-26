package com.project.tetolicio.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.tetolicio.model.Baby;
import com.project.tetolicio.service.BabyService;

@RestController
public class BabyController {
	
	@Autowired 
	BabyService babyService;

	@RequestMapping(method=RequestMethod.POST, value="/baby", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Baby> createBabyInfo(@RequestBody Baby baby) {

		System.out.println("Heeyyyyy: " + baby.getName());
		
		babyService.save(baby);
		
		return new ResponseEntity<Baby>(baby, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/baby/{id}")
	public ResponseEntity<Baby> deleteBaby(@PathVariable Integer id) {
			
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/baby")
	public ResponseEntity<List<Baby>> getAll() {
			
		return new ResponseEntity<List<Baby>>(babyService.getAll(), HttpStatus.OK);
	}
		
}
