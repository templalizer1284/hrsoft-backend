package dev.aleksandarm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.data.Data_Client;
import dev.aleksandarm.services.Service_Client;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/client")
public class Controller_Rest_Client {
	
	@Autowired
	Service_Client service;
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> add(@RequestParam("name") String name) {
		return service.add(name);
	}
	
	@GetMapping(path = "/get")
	public List<Data_Client> get(
			@RequestParam("all") Boolean all, 
			@RequestParam("name") String name) {
		return service.get(all, name);
	}
}
