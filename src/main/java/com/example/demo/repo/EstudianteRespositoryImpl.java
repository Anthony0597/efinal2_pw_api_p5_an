package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteRespositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public List<Estudiante> seleccionarTodos() {
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
		return query.getResultList();
	}

}
