package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	//CRUD
		//Crate, READ, UPDATE(parcial), DELETE
		public void guardar(EstudianteTO estudiante);		
		public List<EstudianteTO> consultarTodosTO();
}
