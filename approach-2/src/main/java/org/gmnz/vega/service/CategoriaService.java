package org.gmnz.vega.service;


import org.gmnz.vega.domain.Categoria;

import java.util.List;


/**
 * creato da simone in data 26/03/2018.
 */
public interface CategoriaService {

	List<Categoria> getAll() throws CategoriaServiceException;

	void create(String name) throws CategoriaServiceException;

	void get(String name);

	void rename(String oldName, String newName) throws CategoriaServiceException;

	void remove(String name);
}
