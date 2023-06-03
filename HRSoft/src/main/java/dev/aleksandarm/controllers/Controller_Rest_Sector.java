package dev.aleksandarm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.aleksandarm.data.Data_Sector;
import dev.aleksandarm.services.Service_Sector;

@RestController
@RequestMapping(value = "/api/sector")
public class Controller_Rest_Sector {
	
	@Autowired
	Service_Sector service;
	
	@GetMapping(path = "get")
	public List<Data_Sector> get() {
		return service.get();
	}
}
