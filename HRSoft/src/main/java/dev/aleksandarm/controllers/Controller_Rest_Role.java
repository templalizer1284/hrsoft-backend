package dev.aleksandarm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.data.Data_Role;
import dev.aleksandarm.services.Service_Role;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/role")
public class Controller_Rest_Role {
	
	@Autowired
	Service_Role service;
	
	@GetMapping(path = "/get")
	public List<Data_Role> get() {
		return service.get();
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> add(String name) {
		return service.add(name);
	}
	
	@DeleteMapping(path = "/delete")
	public ResponseEntity<String> delete(String name) {
		return service.delete(name);
	}
}
