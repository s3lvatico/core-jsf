package org.gmnz.vega.domain;


import org.gmnz.vega.base.AbstractListManagedPropertyHolder;
import org.gmnz.vega.base.NamedEntity;

import java.util.List;


public class Categoria extends AbstractListManagedPropertyHolder<Allergene> {

	public static final Categoria DEFAULT_CATEGORIA = new Categoria(NamedEntity.DEFAULT_CATEGORY_NAME);


	public Categoria(String nome) {
		super(nome);
	}



	public List<Allergene> getAllergeni() {
		return getListProperty();
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		Categoria c = (Categoria) obj;

		return getNome().equals(c.getNome());
	}



	@Override
	public String toString() {
		return "Categoria{" +
				"nome='" + getNome() + '\'' +
				", allergeni=" + listProperty +
				'}';
	}
}
