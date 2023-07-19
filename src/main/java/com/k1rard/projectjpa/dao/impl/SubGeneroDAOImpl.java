package com.k1rard.projectjpa.dao.impl;

import java.util.List;

import com.k1rard.projectjpa.dao.SubGeneroDAO;
import com.k1rard.projectjpa.entities.SubGenero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author k1rard
 * Clase que implementa el CRUD para las transacciones a la tabla de subgenero
 */
public class SubGeneroDAOImpl implements SubGeneroDAO{
	
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("testPU");

	@Override
	public void guardar(SubGenero subGenero) {
		EntityManager em = EMF.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		try {
			em.persist(subGenero);
			et.commit();
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void actualizar(SubGenero subGenero) {
		EntityManager em = EMF.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		try {
			em.merge(subGenero);
			et.commit();
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void eliminar(Long id) {
		EntityManager em = EMF.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		SubGenero subGenero = em.find(SubGenero.class, id);
		
		et.begin();
		
		try {
			em.remove(subGenero);
			et.commit();
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<SubGenero> consultar() {
		EntityManager em = EMF.createEntityManager();
		
		return em.createQuery("FROM SubGenero ORDER BY descripcion", SubGenero.class)
				.getResultList();
	}

	@Override
	public SubGenero consultarById(Long id) {
		EntityManager em = EMF.createEntityManager();
		
		return em.find(SubGenero.class, id);
	}

}
