package dev.aleksandarm.data;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Data_Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String client;
	private Integer revenue;
	
	// If 'onetime' is set to true then this income is one time only for
	// particular period. By default its false unless stated otherwise.
	@Column(columnDefinition = "boolean default false")
	private Boolean onetime;
	private LocalDate period;
}
