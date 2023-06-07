package dev.aleksandarm.services.implementations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.aleksandarm.services.Service_Misc;

@Service
public class Service_Impl_Misc implements Service_Misc {
	
	@Override
	public ResponseEntity<String> version() {
		return new ResponseEntity<String> ("Todo, NULL", HttpStatus.NOT_IMPLEMENTED);
	}
}
