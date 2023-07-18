/**
 * 
 */
package com.k1rard.projectjpa.dao;

import java.util.List;

import com.k1rard.projectjpa.entities.Disquera;

/**
 * @author k1rard
 * Interface que genera el DAO para las transacciones del CRUD a la tabla de disquera
 */
public interface DisqueraDAO {

	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);
}
