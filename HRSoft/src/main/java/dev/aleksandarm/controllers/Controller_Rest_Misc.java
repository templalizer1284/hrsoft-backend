package dev.aleksandarm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.services.Service_Misc;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api")
public class Controller_Rest_Misc {
	
	@Autowired
	Service_Misc service;
	
	@GetMapping(path = "/version")
	public ResponseEntity<String> version() {
		return service.version();
	}
}
