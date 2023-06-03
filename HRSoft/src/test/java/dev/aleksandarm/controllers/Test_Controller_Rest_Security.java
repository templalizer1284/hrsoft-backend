package dev.aleksandarm.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.aleksandarm.data.Data_Security;

@SpringBootTest
@AutoConfigureMockMvc
public class Test_Controller_Rest_Security {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@WithMockUser
	public void register() throws Exception {
		
		Data_Security user = new Data_Security(
				"test", "test123", "user"
				);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		
		mvc.perform(
				post("/api/security/register")
				.content(json))
		.andExpect(status().is2xxSuccessful());
	}
}
