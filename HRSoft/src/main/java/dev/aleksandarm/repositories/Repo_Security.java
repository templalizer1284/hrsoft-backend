package dev.aleksandarm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Security;

public interface Repo_Security extends JpaRepository<Data_Security, Long>{
	Boolean existsByUsername(String username);
}
