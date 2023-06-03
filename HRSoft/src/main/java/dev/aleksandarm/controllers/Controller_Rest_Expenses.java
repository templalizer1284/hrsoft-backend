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

import dev.aleksandarm.data.Data_Expenses;
import dev.aleksandarm.services.Service_Expenses;

@RestController
@CrossOrigin()
@RequestMapping(value = "/expenses")
public class Controller_Rest_Expenses {
	
	@Autowired
	Service_Expenses service;
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> add(@RequestBody Data_Expenses e) {
		return service.add(e);
	}
	
	@DeleteMapping(path = "/remove")
	public ResponseEntity<String> remove(@RequestBody Data_Expenses e) {
		return service.remove(e);
	}
	
	@GetMapping(path = "/get")
	public List<Data_Expenses> get() {
		return service.get();
	}
	
	@GetMapping(path = "/calculate")
	public ResponseEntity<Integer> calculate(@RequestParam("month") Integer month) {
		return service.calculate(month);
	}
}
