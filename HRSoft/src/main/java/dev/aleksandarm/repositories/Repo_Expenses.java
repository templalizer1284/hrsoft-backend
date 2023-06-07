package dev.aleksandarm.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Expenses;

public interface Repo_Expenses extends JpaRepository<Data_Expenses, Long>{
	Boolean existsByName(String name);
}
