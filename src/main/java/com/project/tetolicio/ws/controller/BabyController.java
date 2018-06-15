package com.project.tetolicio.ws.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.tetolicio.model.Baby;

@RestController
public class BabyController {
	
	private Map<Integer, Baby> babies;
	
	@RequestMapping(method=RequestMethod.POST, value="createBabyInfo", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Baby> createBabyInfo(@RequestBody Baby baby) {
		
		if (babies == null) {
			babies = new HashMap<>();
		}
		
		babies.put(baby.getId(), baby);
		System.out.println("Heeyyyyy: " + baby.getName());
		
		return new ResponseEntity<Baby>(baby, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="getBaby")
	public void getBaby() {
		
		System.out.println("Babyyy");
		
	}

	private class BabyInfo {
		private String name;
		
		@SuppressWarnings("unused")
		public BabyInfo() {
			super();
		}
		
		public void setName(String n) {
			name = n;
		}
		public String getName() {
			return this.name;
		}

	}
}
