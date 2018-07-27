package com.project.tetolicio.service;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.tetolicio.model.Baby;
import com.project.tetolicio.repository.BabyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class BabyServiceTest {

	@Configuration
	static class BabyServiceTestContextConfiguration {
	
		@Bean
		public BabyService babyService() {
			return new BabyService();
		}
		
		@Bean
		public BabyRepository babyRepository() {
		return Mockito.mock(BabyRepository.class);
		}
	}
	
	@Autowired
	private BabyService babyService;

	@Autowired
	private BabyRepository babyRepository;

	private static final String Matheus = "Matheus Nagamine Schiozer";
	
	@Test
	public void testSave() {
		
		try {

			Baby b = new Baby();
			b.setName(Matheus);

			Date dt = java.text.DateFormat.getDateInstance(DateFormat.SHORT,Locale.US).parse("01/08/2018");
			b.setBirth(dt);
			
			babyService.save(b);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemove() {

		try {
			Baby b = new Baby();
			Date dt = java.text.DateFormat.getDateInstance(DateFormat.SHORT,Locale.US).parse("01/08/2018");
			b.setName(Matheus);
			b.setBirth(dt);
			
			Baby ret = babyService.save(b);
	
			babyService.remove(ret.getId());

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


}
