package com.project.tetolicio.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.tetolicio.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BabyRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
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
		
			Baby ret = entityManager.persist(b);
			
			entityManager.flush();
			
			 assertThat(ret.getName())
		      .isEqualTo(b.getName());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/*
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void testFindOne() {
		
		try {
			Baby b = new Baby();
			b.setName(Matheus);

			Date dt = java.text.DateFormat.getDateInstance(DateFormat.SHORT,Locale.US).parse("01/08/2018");
			b.setBirth(dt);
		
			entityManager.persist(b);		
			entityManager.flush();
	
			Example<Baby> example = Example.of(b);
			
			Optional<Baby> ret = babyRepository.findOne(example);
			
			 assertThat(ret.get().getName())
		      .isEqualTo(b.getName());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
