package com.example.APIProduct.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "category")
	private String category;
	@Column(name = "color")
	private String color;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private Double price;
	@Column(name = "available")
	private Boolean available;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "expireDate")
	private LocalDate expireDate;
	/*
	 * @ManyToOne private Supermarket supermarket;
	 */
	@Column(name = "imageUrl")
	private String imageUrl;

	// Constructor vacío
	public Product() {

	}

	// Constructor con parámetros
	public Product(int id, String name, String category, String color, String description, Double price,
			Boolean available, Integer quantity, LocalDate expireDate, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.color = color;
		this.description = description;
		this.price = price;
		this.available = available;
		this.quantity = quantity;
		this.expireDate = expireDate;
		this.imageUrl = imageUrl;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	/*
	 * public Supermarket getSupermarket() { return supermarket; }
	 * 
	 * public void setSupermarket(Supermarket supermarket) { this.supermarket =
	 * supermarket; }
	 */

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	// Método toString() sobreescrito
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", color=" + color + ", description="
				+ description + ", price=" + price + ", available=" + available + ", quantity=" + quantity
				+ ", expireDate=" + expireDate + ",  imageUrl=" + imageUrl + "]";
	}

}
