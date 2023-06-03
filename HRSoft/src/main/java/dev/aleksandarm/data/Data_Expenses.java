package dev.aleksandarm.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Data_Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private Integer price;
	private String client; // Client
	
	// For particular month and year.
	// If these are set expense is only one time.
	@Column(columnDefinition = "integer default 0")
	private Integer month, year;
	
	public Data_Expenses() {
		super();
	}

	public Data_Expenses(String name, Integer price, String client, Integer month, Integer year) {
		super();
		this.name = name;
		this.price = price;
		this.client = client;
		this.month = month;
		this.year = year;
	}

	public Data_Expenses(Long id, String name, Integer price, String client, Integer month, Integer year) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.client = client;
		this.month = month;
		this.year = year;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
