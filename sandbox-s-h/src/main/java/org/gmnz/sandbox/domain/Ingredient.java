package org.gmnz.sandbox.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient extends BaseEntity {

	@Column
	private boolean freezed = false;

	public Ingredient() {}
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
