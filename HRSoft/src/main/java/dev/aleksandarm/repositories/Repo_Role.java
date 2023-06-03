package dev.aleksandarm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Role;

public interface Repo_Role extends JpaRepository<Data_Role, Long>{
	Boolean existsByName(String name);
	Data_Role findByName(String name);
}
