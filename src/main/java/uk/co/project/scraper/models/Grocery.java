package uk.co.project.scraper.models;

import java.math.BigDecimal;
import java.util.Objects;
import org.json.JSONPropertyName;

public class Grocery {

	private String description;
	private Integer kcals;
	private String title;
	private BigDecimal unitPrice;
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Grocery)) return false;
		Grocery grocery = (Grocery) object;
		return Objects.equals(description, grocery.description) && Objects.equals(kcals, grocery.kcals) 
				&& Objects.equals(title, grocery.title) && Objects.equals(unitPrice, grocery.unitPrice);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(description, kcals, title, unitPrice);
	}
	
	public String getDescription() {
		return description;
	}
	
	@JSONPropertyName("kcal_per_100g")
	public Integer getKcals() {
		return kcals;
	}
	
	public String getTitle() {
		return title;
	}
	
	@JSONPropertyName("unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setKcals(Integer kcals) {
		this.kcals = kcals;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}