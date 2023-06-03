package dev.aleksandarm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.aleksandarm.data.Data_Employee;

public interface Service_Employee {
	public abstract List<Data_Employee> get();
	public abstract ResponseEntity<String> terminate(Long id);
	public abstract ResponseEntity<String> modify(Long id, String sector);
	public abstract ResponseEntity<String> recruit(Data_Employee e);
	public abstract ResponseEntity<String> invoice(Long id, Integer month);
}
