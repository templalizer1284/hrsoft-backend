package dev.aleksandarm.data;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Data_Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String client;
	private Integer revenue;
	
	public Data_Income() {
		super();
	}

	public Data_Income(String name, String client, Integer revenue) {
		super();
		this.name = name;
		this.client = client;
		this.revenue = revenue;
	}

	public Data_Income(Long id, String name, String client, Integer revenue) {
		super();
		this.id = id;
		this.name = name;
		this.client = client;
		this.revenue = revenue;
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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getRevenue() {
		return revenue;
	}

	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}
}
