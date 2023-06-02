package dev.aleksandarm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.aleksandarm.data.Data_Client;

public interface Service_Client {
	public abstract ResponseEntity<String> add(String name);
	public abstract List<Data_Client> get(Boolean all, String name);
}
