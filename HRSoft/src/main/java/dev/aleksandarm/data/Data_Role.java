package dev.aleksandarm.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Data_Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String role;
	private Integer pph; // Price per hour
	
	public Data_Role() {
		super();
	}

	public Data_Role(String role, Integer pph) {
		super();
		this.role = role;
		this.pph = pph;
	}

	public Data_Role(Long id, String role, Integer pph) {
		super();
		this.id = id;
		this.role = role;
		this.pph = pph;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getPph() {
		return pph;
	}

	public void setPph(Integer pph) {
		this.pph = pph;
	}
}
