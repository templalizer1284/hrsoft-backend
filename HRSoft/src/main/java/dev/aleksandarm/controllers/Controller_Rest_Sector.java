package dev.aleksandarm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.data.Data_Sector;
import dev.aleksandarm.services.Service_Sector;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/sector")
public class Controller_Rest_Sector {
	
	@Autowired
	Service_Sector service;
	
	@GetMapping(path = "/get")
	public List<Data_Sector> get() {
		return service.get();
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> add(@RequestParam("name") String name) {
		return service.add(name);
	}
	
	@DeleteMapping(path = "/delete")
	public ResponseEntity<String> delete(@RequestParam("name") String name) {
		return service.delete(name);
	}
}
