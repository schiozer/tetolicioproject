package com.project.tetolicio.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.tetolicio.model.Baby;
import com.project.tetolicio.service.BabyService;
import com.project.tetolicio.ws.controller.BabyController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BabyController.class)
public class BabyControllerTest {

	@Autowired
    private MockMvc mvc;
      
	@MockBean
    private BabyService service;
	
	private static final String Matheus = "Matheus Nagamine Schiozer";
	
	@Test
	public void testCreateBabyInfo() {

		try {
			Baby b = new Baby();
			b.setName(Matheus);
			Date dt = java.text.DateFormat.getDateInstance(DateFormat.SHORT,Locale.US).parse("01/08/2018");
			b.setBirth(dt);
			
			// Using Jackson
			// https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
			ObjectMapper mapper = new ObjectMapper();
			byte[] jsonb = mapper.writeValueAsBytes(b);
			String json = mapper.writeValueAsString(b);
			
			mvc.perform(MockMvcRequestBuilders.post("/baby")
					.contentType(MediaType.APPLICATION_JSON).content(json))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name", is(b.getName())));
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
