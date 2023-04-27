package com.example.ApiAula.controller;

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

import com.example.ApiAula.model.Aula;
import com.example.ApiAula.repository.AulaRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AulaController {

	@Autowired
	AulaRepository aulaRepository;

	// Obtener todas las aulas
	@GetMapping("/aulas")
	public ResponseEntity<List<Aula>> getAll() {
		try {
			List<Aula> aulas = aulaRepository.findAll();

			if (aulas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(aulas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Obtener aula por ID
	@GetMapping("/aulas/{id}")
	public ResponseEntity<Aula> getById(@PathVariable("id") int id) {
		Optional<Aula> aula = aulaRepository.findById(id);

		if (aula.isPresent()) {
			return new ResponseEntity<>(aula.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Crear/ Guardar nuevaa aula
	@PostMapping("/aulas")
	public ResponseEntity<Aula> create(@RequestBody Aula aula) {
		try {
			Aula newAula = new Aula(0, aula.getNombre(), aula.getCapacidad());
			newAula = aulaRepository.save(newAula);
			return new ResponseEntity<>(newAula, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/// Actualizar y guardar aula
	@PutMapping("aulas/{id}")
	public ResponseEntity<Aula> update(@PathVariable("id") int id, @RequestBody Aula aula) {
		try {
			Optional<Aula> newAula = aulaRepository.findById(id);
			if (newAula.isPresent()) {
				Aula updAula = newAula.get();
				updAula.setNombre(aula.getNombre());
				updAula = aulaRepository.save(updAula);
				return new ResponseEntity<>(updAula, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Borrar aula por ID
	@DeleteMapping("/aulas/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
		try {
			aulaRepository.deleteById(id);
			return ResponseEntity.ok(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
