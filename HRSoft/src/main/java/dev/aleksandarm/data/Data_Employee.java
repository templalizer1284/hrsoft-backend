package dev.aleksandarm.data;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Data_Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate dob;
	
	private String first_name;
	private String last_name;
	private String sector;
	private String role;
	private String client;
	private Integer pph; // Price per hour
	
	public Data_Employee() {
		super();
	}

	public Data_Employee(LocalDate dob, String first_name, String last_name, String sector, String role,
			String client, Integer pph) {
		super();
		this.dob = dob;
		this.first_name = first_name;
		this.last_name = last_name;
		this.sector = sector;
		this.role = role;
		this.client = client;
		this.pph = pph;
	}

	public Data_Employee(Long id, LocalDate dob, String first_name, String last_name, String sector, String role,
			String client, Integer pph) {
		super();
		this.id = id;
		this.dob = dob;
		this.first_name = first_name;
		this.last_name = last_name;
		this.sector = sector;
		this.role = role;
		this.client = client;
		this.pph = pph;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	public Integer getPph() {
		return pph;
	}
	
	public void setPph(Integer pph) {
		this.pph = pph;
	}
}
