package dev.aleksandarm.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Data_Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	// Number of employees. This is updated dynamically
	// with employee recruitment/layoff/relocation.
	@Column(columnDefinition = "integer default 0")
	private Integer noe;

	public Data_Client() {
		super();
	}

	public Data_Client(String name, Integer noe) {
		super();
		this.name = name;
		this.noe = noe;
	}

	public Data_Client(Long id, String name, Integer noe) {
		super();
		this.id = id;
		this.name = name;
		this.noe = noe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNoe() {
		return noe;
	}

	public void setNoe(Integer noe) {
		this.noe = noe;
	}
}
