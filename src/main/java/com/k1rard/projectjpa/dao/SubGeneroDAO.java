package com.k1rard.projectjpa.dao;

import java.util.List;

import com.k1rard.projectjpa.entities.SubGenero;

/**
 * @author k1rard
 * Interface DAO que realiza el CRUD para la tabla de subgenero
 */
public interface SubGeneroDAO {

	/**
	 * Metodo que permite guardar un subgenero.
	 * @param subGenero {@link SubGenero} objeto a guardar.
	 */
	void guardar(SubGenero subGenero);
	/**
	 * Metodo que permite actualizar un subgenero.
	 * @param subGenero {@link SubGenero} objeto a actualizar.
	 */
	void actualizar(SubGenero subGenero);
	/**
	 * Metodo que permite eliminar un subgenero por su identificador.
	 * @param id {@link Long} identificador el subgenero a eliminar.
	 */
	void eliminar(Long id);
	/**
	 * Metodo que permite consultar la lista de subgeneros
	 * @return {@link List} lista de subgeneros consultados.
	 */
	List<SubGenero> consultar();
	/**
	 * Metodo que permite consultar un subgenero a partir de su identifiacor
	 * @param id {@link Long} Identificador de subgenero a consultar
	 * @return {@link SubGenero} objeto SubGenero consultado
	 */
	SubGenero consultarById(Long id);
}
