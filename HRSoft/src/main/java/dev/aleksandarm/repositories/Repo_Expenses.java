package dev.aleksandarm.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleksandarm.data.Data_Expenses;

public interface Repo_Expenses extends JpaRepository<Data_Expenses, Long>{
	Boolean existsByName(String name);
}
