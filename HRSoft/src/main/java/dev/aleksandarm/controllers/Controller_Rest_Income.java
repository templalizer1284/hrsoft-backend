package dev.aleksandarm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.data.Data_Income;
import dev.aleksandarm.services.Service_Income;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/income")
public class Controller_Rest_Income {
	
	@Autowired
	Service_Income service;
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> add(@RequestBody Data_Income income) {
		return service.add(income);
	}
	
	@DeleteMapping(path = "/delete")
	public ResponseEntity<String> delete(
			@RequestParam("name") String name,
			@RequestParam("client") String client) {
		return service.delete(name, client);
	}
	
	@GetMapping(path = "/fetch")
	public ResponseEntity<List<Data_Income>> fetch(
			@RequestParam("client") String client) {
		return service.fetch(client);
	}
	
	@GetMapping(path = "/calculate")
	public ResponseEntity<Integer> calculate() {
		return service.calculate();
	}
}
