package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepository;
import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(this.convertirEst(estudiante));
	}


	@Override
	public List<EstudianteTO> consultarTodosTO() {
		List<Estudiante> lista = this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO> listaFinal=new ArrayList<>();
		for(Estudiante e : lista) {
			listaFinal.add(this.convertir(e));
		}
		return listaFinal;
	}
	
	private EstudianteTO convertir(Estudiante est) {
		EstudianteTO estuTO= new EstudianteTO();
		estuTO.setNombre(est.getNombre());
		estuTO.setApellido(est.getApellido());
		estuTO.setId(est.getId());
		estuTO.setCedula(est.getCedula());
		return estuTO;
	}
	
	private Estudiante convertirEst(EstudianteTO est) {
		Estudiante estu= new Estudiante();
		estu.setNombre(est.getNombre());
		estu.setApellido(est.getApellido());
		estu.setId(est.getId());
		estu.setCedula(est.getCedula());
		return estu;
	}
	
	

}
