package org.gmnz.sb;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@ManagedBean(name = "beverages")
@SessionScoped
public class BeveragesPrices implements Serializable {

	private static final long serialVersionUID = 1378539647667698454L;

	private String name;
	private Double price;

	private Map<String, Double> priceMap;



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public void beverageSelected(ValueChangeEvent e) {
		String selectedBeverage = e.getNewValue().toString();
		price = priceMap.get(selectedBeverage);
	}



	@PostConstruct
	public void fillPricesMap() {

		System.out.println("initializing prices map");

		priceMap = new HashMap<>();
		priceMap.put("t", 1.50d);
		priceMap.put("c", 1d);
		priceMap.put("o", 2.50d);

		System.out.println("initialization complete");

	}
}
