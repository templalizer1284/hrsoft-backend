package dev.aleksandarm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.aleksandarm.data.Data_Security;

public interface Service_Security {
	public abstract List<Data_Security> fetch_users();
	public abstract ResponseEntity<String> register(Data_Security user) throws Exception;
}
