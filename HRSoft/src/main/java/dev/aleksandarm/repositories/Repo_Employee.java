package dev.aleksandarm.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Employee;

public interface Repo_Employee extends JpaRepository<Data_Employee, Long>{
	Boolean existsBySector(String sector);
}
