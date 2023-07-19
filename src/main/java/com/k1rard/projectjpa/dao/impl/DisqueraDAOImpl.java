/**
 * 
 */
package com.k1rard.projectjpa.dao.impl;

import java.util.List;

import com.k1rard.projectjpa.dao.DisqueraDAO;
import com.k1rard.projectjpa.entities.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author k1rard Clase que implementa las transacciones para la tabla de
 *         Disquera.
 */
public class DisqueraDAOImpl implements DisqueraDAO {

	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("testPU");

	@Override
	public void guardar(Disquera disquera) {

		EntityManager em = EMF.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void actualizar(Disquera disquera) {

		EntityManager em = EMF.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
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
		
		et.begin();
		
		Disquera disquera = em.find(Disquera.class, id);
				
		try {
			em.remove(disquera);
			et.commit();
		} catch (Exception e) {

			if (et != null) {
				et.rollback();
			}

			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public List<Disquera> consultar() {
		
		List<Disquera> disqueras = null;

		EntityManager em = EMF.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			disqueras = em.createQuery("FROM Disquera", Disquera.class).getResultList(); 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return disqueras;
	}

	@Override
	public Disquera consultarById(Long id) {

		EntityManager em = EMF.createEntityManager();

		Disquera disquera = em.find(Disquera.class, id);
		
		if(disquera == null) {
			throw new EntityNotFoundException("La diquera con id " + id  + " no se encontro");
		}

		return disquera;
	}

	@Override
	public Disquera consultarByDescripcionJPQL(String descripcion) {
		EntityManager em = EMF.createEntityManager();
		
		Disquera disquera = em.createQuery("SELECT d FROM Disquera d WHERE d.descripcion =:desc", Disquera.class)
				.setParameter("desc", descripcion).getSingleResult();
		
		return disquera;
	}

	@Override
	public Disquera consultarByDescripcionNative(String descripcion) {
		EntityManager em = EMF.createEntityManager();
		
		return (Disquera) em.createNativeQuery("SELECT * FROM disquera WHERE descripcion = :desc", Disquera.class)
				.setParameter("desc", descripcion).getSingleResult();
	}

}
