package dev.aleksandarm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.data.Data_Employee;
import dev.aleksandarm.services.Service_Employee;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/employee")
public class Controller_Rest_Employee {
	
	@Autowired
	Service_Employee service;
	
	@GetMapping(path = "/get_one")
	public ResponseEntity<Data_Employee> get_one(@RequestParam("id") Long id) {
		return service.get_one(id);
	}
	
	@GetMapping(path = "/get")
	public List<Data_Employee> get() {
		return service.get();
	}
	
	@DeleteMapping(path = "/terminate")
	public ResponseEntity<String> terminate(@RequestParam("id") Long id) {
		return service.terminate(id);
	}
	
	@PatchMapping(path = "/modify")
	public ResponseEntity<String> modify(
			@RequestParam("id") Long id, 
			@RequestParam("sector") String sector, 
			@RequestParam("role") String role,
			@RequestParam("pph") Integer pph,
			@RequestParam("client") String client) {
		return service.modify(id, sector, role, pph, client);
	}
	
	@PostMapping(path = "/recruit")
	public ResponseEntity<String> recruit(@RequestBody Data_Employee e) {
		return service.recruit(e);
	}
	
	@GetMapping(path = "/invoice")
	public ResponseEntity<String> invoice(
			@RequestParam("id") Long id,
			@RequestParam("month") Integer month) {
		return service.invoice(id, month);
	}
}
