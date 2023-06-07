package dev.aleksandarm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.aleksandarm.data.Data_Income;

public interface Service_Income {
	public abstract ResponseEntity<String> add(Data_Income income);
	public abstract ResponseEntity<String> delete(String name, String client);
	public abstract ResponseEntity<List<Data_Income>> get();
	public abstract ResponseEntity<List<Data_Income>> fetch(String client);
	public abstract ResponseEntity<Integer> calculate();
}
