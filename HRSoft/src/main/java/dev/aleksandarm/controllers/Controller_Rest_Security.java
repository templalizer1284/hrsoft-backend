package dev.aleksandarm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.data.Data_Security;
import dev.aleksandarm.services.Service_Security;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/security")
public class Controller_Rest_Security {

	@Autowired
	Service_Security service;
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> register(@RequestBody Data_Security user) throws Exception {
		return service.register(user);
	}
}
