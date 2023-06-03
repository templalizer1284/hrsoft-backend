package dev.aleksandarm.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Sector;
import dev.aleksandarm.repositories.Repo_Sector;
import dev.aleksandarm.services.Service_Sector;

@Service
public class Service_Impl_Sector implements Service_Sector {

	@Autowired
	Repo_Sector repo;
	
	@Override
	public List<Data_Sector> get() {
		return repo.findAll();
	}
}
