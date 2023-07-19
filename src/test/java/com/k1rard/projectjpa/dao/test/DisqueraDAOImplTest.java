/**
 * 
 */
package com.k1rard.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.k1rard.projectjpa.dao.DisqueraDAO;
import com.k1rard.projectjpa.dao.impl.DisqueraDAOImpl;
import com.k1rard.projectjpa.entities.Disquera;

/**
 * 
 */
class DisqueraDAOImplTest {
	
	private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.DisqueraDAOImpl#guardar(com.k1rard.projectjpa.entities.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("Sony music");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.DisqueraDAOImpl#actualizar(com.k1rard.projectjpa.entities.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada =  this.disqueraDAO.consultarById(9L);
		
		disqueraConsultada.setDescripcion("Disquera IronMaiden");
		
		this.disqueraDAO.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.DisqueraDAOImpl#eliminar(com.k1rard.projectjpa.entities.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 9L;
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disqueras = this.disqueraDAO.consultar();
		
		assertTrue(disqueras.size() > 0);
		disqueras.forEach(d -> System.out.println(d.getDescripcion()));
	}

	/**
	 * Test method for {@link com.k1rard.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(9L);
		
		System.out.println("Disquera: " + disquera.getDescripcion());
	}
	
	@Test
	void testConsultarByDescripcionJPQL() {
		Disquera disquera = this.disqueraDAO.consultarByDescripcionJPQL("Sony music");
		
		assertNotNull(disquera);
		assertEquals("Sony music", disquera.getDescripcion());
	}

	@Test
	void consultarByDescripcionNativeTest() {
		Disquera disquera = this.disqueraDAO.consultarByDescripcionNative("Sony music");
		
		assertNotNull(disquera);
		assertEquals("Sony music", disquera.getDescripcion());
		
		System.out.println("Descripcion: " + disquera.getDescripcion());
	}
}
