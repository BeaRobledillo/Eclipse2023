package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")

public class Country {
	
	@Id
	@Column (name="country_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int country_id;
	
	@Column(name="country")
	private String country;

	public Country() {
		super();
	}

	
	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
	}


	public int getCountry_id() {
		return country_id;
	}


	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + "]";
	}

	
	

}
