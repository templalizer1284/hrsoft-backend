package dev.aleksandarm.services.implementations;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Employee;
import dev.aleksandarm.data.Data_Expenses;
import dev.aleksandarm.data.Data_Sector;
import dev.aleksandarm.repositories.Repo_Employee;
import dev.aleksandarm.repositories.Repo_Expenses;
import dev.aleksandarm.repositories.Repo_Sector;
import dev.aleksandarm.services.Service_Expenses;


@Service
public class Service_Impl_Expenses implements Service_Expenses{
	
	@Autowired
	Repo_Expenses repo;
	
	@Autowired
	Repo_Sector sector_repo;
	
	@Autowired
	Repo_Employee employee_repo;
	
	@Override
	public ResponseEntity<String> add(Data_Expenses e) {
		if(repo.existsByName(e.getName())) {
			return new ResponseEntity<String> ("Expense by that name already exist.", HttpStatus.IM_USED);
		} else {
			repo.save(e);
			return new ResponseEntity<String> ("Expenses is noted.", HttpStatus.ACCEPTED);
		}
	}
	
	@Override
	public ResponseEntity<String> remove(Data_Expenses e) {
		if(repo.existsByName(e.getName())) {
			repo.delete(e);
			return new ResponseEntity<String> ("Expenses removed.", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String> ("Expense doesn't exist.", HttpStatus.ACCEPTED);
		}
	}
	
	@Override
	public List<Data_Expenses> get() {
		return repo.findAll();
	}
	
	@Override
	public ResponseEntity<Integer> calculate(Integer month) {
		// Get current date as a starting date.
		LocalDate startDate = LocalDate.now();
		if(month != 100) {
			startDate = startDate.withMonth(month);
		}
				
		// Set it to the first day of current month.
		startDate = startDate.withDayOfMonth(1);
				
		// Create end date exactly one month after starting date.
		LocalDate endDate = startDate.plusMonths(1L);
				
		// Set approved working days, aka first five days of week.
		final Set<DayOfWeek> workingDays = Set.of(
				DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
				DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);
				
		// Get all working days between starting date and ending date.
		List<LocalDate> allDates = startDate.datesUntil(endDate)
				.filter(t -> workingDays.contains(t.getDayOfWeek()))
				.collect(Collectors.toList());
				
		// Get all expenses
		List<Data_Expenses> exp = repo.findAll();
				
		int exp_sum = 0;
				
		// Check if empty.
		if(exp.isEmpty()) {
			return new ResponseEntity<Integer> (0, HttpStatus.ACCEPTED);
		}
				
		// Calculate all expenses.
		for(int i = 0; i < exp.size(); i++) {
			exp_sum += exp.get(i).getPrice();
		}
		// Get Salaries
		List<Data_Employee> emp = employee_repo.findAll();
		
		System.out.print(emp.get(0).getPph());
				
		int sal_sum = 0; // Salary sum
				
		// If not empty
		if(emp.isEmpty()) {
			return new ResponseEntity<Integer> (0, HttpStatus.ACCEPTED);
		}
				
		// Calculate salaries.
		for(int i = 0; i < emp.size(); i++) {
			sal_sum += (((allDates.size() * 8) * emp.get(i).getPph()));
		}
				
		exp_sum += sal_sum;
				
		return new ResponseEntity<Integer> (exp_sum, HttpStatus.OK);
	}
}
