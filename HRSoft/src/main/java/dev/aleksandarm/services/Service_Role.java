package dev.aleksandarm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.aleksandarm.data.Data_Role;

public interface Service_Role {
	public abstract List<Data_Role> get();
	public abstract ResponseEntity<String> add(String name);
	public abstract ResponseEntity<String> delete(String name);
}
