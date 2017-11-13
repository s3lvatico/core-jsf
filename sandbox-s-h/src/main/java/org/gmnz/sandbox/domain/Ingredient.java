package org.gmnz.sandbox.domain;


import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@NamedQueries({
		@NamedQuery(name = "searchByName", query = "select  i from Ingredient i where i.name like :searchPattern"),
		@NamedQuery(name = "getByName", query = "select  i from Ingredient i where i.name = :name")
})
public class Ingredient extends BaseEntity {

	@Column
	private boolean freezed = false;

	public Ingredient() {
	}

	public Ingredient(String id) {
		this.id = id;
	}

	public boolean isFreezed() {
		return freezed;
	}

	public void setFreezed(boolean freezed) {
		this.freezed = freezed;
	}

	@Override
	public String toString() {
		return "Ingredient{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", freezed=" + freezed +
				'}';
	}
}
