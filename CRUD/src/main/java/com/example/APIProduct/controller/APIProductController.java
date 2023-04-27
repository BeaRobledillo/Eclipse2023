package com.example.APIProduct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.APIProduct.model.Product;
import com.example.APIProduct.repository.ProductRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class APIProductController {

	@Autowired
	ProductRepository productRepository;

	// Obtener todos los productos
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll() {
		try {
			List<Product> products = productRepository.findAll();

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Obtener producto por ID
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") int id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Crear/ Guardar nuevo producto
	@PostMapping("/products")
	public ResponseEntity<Product> create(@RequestBody Product product) {
		try {
			Product newProduct = new Product(0, product.getName(), product.getCategory(), product.getColor(),
					product.getDescription(), product.getPrice(), product.getAvailable(), product.getQuantity(),
					product.getExpireDate(), product.getImageUrl());
			newProduct = productRepository.save(newProduct);
			return new ResponseEntity<>(newProduct, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/// Actualizar y guardar prodcuto
	@PutMapping("products/{id}")
	public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody Product product) {
		try {
			Optional<Product> newProduct = productRepository.findById(id);
			if (newProduct.isPresent()) {
				Product updProduct = newProduct.get();
				updProduct.setName(product.getName());
				updProduct = productRepository.save(updProduct);
				return new ResponseEntity<>(updProduct, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Borrar product por ID
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
		try {
			productRepository.deleteById(id);
			return ResponseEntity.ok(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
