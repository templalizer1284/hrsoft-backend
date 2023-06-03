package dev.aleksandarm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.aleksandarm.data.Data_Expenses;

public interface Service_Expenses {
	public abstract ResponseEntity<String> add(Data_Expenses e);
	public abstract ResponseEntity<String> remove(Data_Expenses e);
	public abstract List<Data_Expenses> get();
	public abstract ResponseEntity<Integer> calculate(Integer month);
}
