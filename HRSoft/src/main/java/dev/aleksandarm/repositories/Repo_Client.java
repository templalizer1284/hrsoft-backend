package dev.aleksandarm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Client;

public interface Repo_Client extends JpaRepository<Data_Client, Long>{
	Boolean existsByName(String name);
	Data_Client findByName(String name);
}
