package dev.aleksandarm.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Security;
import dev.aleksandarm.repositories.Repo_Security;
import dev.aleksandarm.services.Service_Security;

@Service
public class Service_Impl_Security implements Service_Security {

	@Autowired
	Repo_Security repo;
	
	@Override
	public List<Data_Security> fetch_users() {
		return repo.findAll();
	}
}
