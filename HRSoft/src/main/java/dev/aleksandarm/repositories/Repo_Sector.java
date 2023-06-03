package dev.aleksandarm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Sector;

public interface Repo_Sector extends JpaRepository<Data_Sector, Long> {
	
}
