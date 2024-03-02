package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTO;


@RestController // Servicios
@RequestMapping(path = "/estudiantes")
@CrossOrigin	
public class EstudianteControllerRestFul {
	@Autowired
	private IEstudianteService estudianteService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHateoas() {
		List<EstudianteTO> lista = this.estudianteService.consultarTodosTO();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

}
