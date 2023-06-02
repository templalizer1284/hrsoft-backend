package dev.aleksandarm.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class Test_Controller_Rest_Client {

	@Autowired
	private MockMvc mvc;
	
	@Test
	@WithMockUser
	public void get() throws Exception {
		this.mvc.perform(
				MockMvcRequestBuilders.get("/api/client/get")
				.param("all", "true")
				.param("name", "test"))
		.andExpect(status().is4xxClientError());
	}
	
}
