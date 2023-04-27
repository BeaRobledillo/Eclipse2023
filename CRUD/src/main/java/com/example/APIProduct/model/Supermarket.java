package com.example.APIProduct.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Supermarket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Long id;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "imageUrl")
	private String imageUrl;
	@Column(name = "initYear")
	private Integer initYear;

}
