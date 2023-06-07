package dev.aleksandarm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Income;

public interface Repo_Income extends JpaRepository<Data_Income, Long>{
	Boolean existsByNameAndClient(String name, String client);
	List<Data_Income> findByClient(String client);
	Data_Income findByNameAndClient(String name, String client);
}
