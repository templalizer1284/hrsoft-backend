package dev.aleksandarm.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Data_Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private Integer price;
	private String client; // Client
	
	// For particular month and year.
	// If these are set expense is only one time.
	private Integer month;
	private Integer year;
}
