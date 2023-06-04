package dev.aleksandarm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.aleksandarm.data.Data_Sector;

public interface Service_Sector {
	public abstract List<Data_Sector> get();
	public abstract ResponseEntity<String> add(String name);
	public abstract ResponseEntity<String> delete(String name);
}
