package dev.aleksandarm.services.implementations;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Employee;
import dev.aleksandarm.data.Data_Sector;
import dev.aleksandarm.repositories.Repo_Employee;
import dev.aleksandarm.repositories.Repo_Sector;
import dev.aleksandarm.services.Service_Employee;

@Service
public class Service_Impl_Employee implements Service_Employee{
	
	@Autowired
	Repo_Employee repo;
	
	@Autowired
	Repo_Sector sector_repo;
	
	@Override
	public ResponseEntity<Data_Employee> get_one(Long id) {
		if(repo.existsById(id)) {
			Optional<Data_Employee> e = repo.findById(id);

			return new ResponseEntity<Data_Employee> (e.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public List<Data_Employee> get() {
		return repo.findAll();
	}
	
	@Override
	public ResponseEntity<String> terminate(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return new ResponseEntity<String> ("Employee successfully removed.", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String> ("Employee doesn't exist by that ID.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public ResponseEntity<String> modify(Long id, String sector, String role, Integer pph, String client) {
		
		if(id == null) {
			return new ResponseEntity<> (HttpStatus.OK);
		}
		
		if(repo.existsById(id)) {
			Data_Employee emp = repo.getById(id); // getById is deprecated
			emp.setSector(sector);
			emp.setRole(role);
			emp.setPph(pph);
			emp.setClient(client);
			
			repo.save(emp); 
			
			return new ResponseEntity<String> ("Contract modified.", HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String> ("Employee doesn't exist by that ID.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public ResponseEntity<String> recruit(Data_Employee e) {
		repo.save(e);
		return new ResponseEntity<String> ("Employee successfully recruited.", HttpStatus.ACCEPTED);
	}
	
	@Override
	public ResponseEntity<String> invoice(Long id, Integer month) {
		if(repo.existsById(id)) {
			//ok
		} else {
			return new ResponseEntity<String> ("Employee by that ID doesn't exist.", HttpStatus.NOT_FOUND);
		}
		
		// Get current date as a starting date.
		LocalDate startDate = LocalDate.now();
		startDate = startDate.withMonth(month);
		startDate = startDate.withDayOfMonth(1);
				
		LocalDate endDate = startDate.plusMonths(1L);
				
		final Set<DayOfWeek> workingDays = Set.of(
				DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
				DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);
				
		List<LocalDate> allDates = startDate.datesUntil(endDate)
				.filter(t -> workingDays.contains(t.getDayOfWeek()))
				.collect(Collectors.toList());
		
		Data_Employee emp = repo.getById(id); // method is deprecated
		Integer sal = (emp.getPph() * (allDates.size() * 8));

		return new ResponseEntity<String> ("Amount of " + sal.toString() + " RSD has been send to " + emp.getFirst_name() + " " + emp.getLast_name() + ".", HttpStatus.ACCEPTED);
	}
}
