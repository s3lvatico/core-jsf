package org.gmnz.vega.service;


import org.gmnz.vega.domain.Categoria;
import org.gmnz.vega.integration.CategoriaDao;
import org.gmnz.vega.integration.DaoException;

import java.util.List;


public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDao categoriaDao;



	public CategoriaServiceImpl(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}



	@Override
	public List<Categoria> getAll() throws CategoriaServiceException {
		try {
			return categoriaDao.findAll();
		} catch (DaoException e) {
			throw new CategoriaServiceException("getAll() service failed", e);
		}

	}



	@Override
	public void create(String name) throws CategoriaServiceException {

	}



	@Override
	public void get(String name) {

	}



	@Override
	public void rename(String oldName, String newName) throws CategoriaServiceException {

	}



	@Override
	public void remove(String name) {

	}
}
