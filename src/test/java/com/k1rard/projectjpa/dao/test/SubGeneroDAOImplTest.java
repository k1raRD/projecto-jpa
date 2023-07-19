/**
 * 
 */
package com.k1rard.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.k1rard.projectjpa.dao.SubGeneroDAO;
import com.k1rard.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.k1rard.projectjpa.entities.Genero;
import com.k1rard.projectjpa.entities.SubGenero;

/**
 * @author k1rard
 * Clase Test para comprobar el funcionamiento de los metodos del CRUD de subgenero.
 */
class SubGeneroDAOImplTest {
	
	private SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.SubGeneroDAOImpl#guardar(com.k1rard.projectjpa.entities.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Hardcore");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		
		this.subGeneroDAO.guardar(subGenero);
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.SubGeneroDAOImpl#actualizar(com.k1rard.projectjpa.entities.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado =  this.subGeneroDAO.consultarById(7L);
		
		subGeneroConsultado.setDescripcion("Trash Metal");
		
		subGeneroConsultado.getGenero().setDescripcion("Metal Trash");
		
		this.subGeneroDAO.actualizar(subGeneroConsultado);
		
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDAO.eliminar(7L);
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados =  this.subGeneroDAO.consultar();
		
		assertTrue(subGenerosConsultados.size() > 0);
		
		subGenerosConsultados.forEach(s -> {
			System.out.println("Subgenero: " + s.getDescripcion());
			System.out.println("Genero: " + s.getGenero().getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
