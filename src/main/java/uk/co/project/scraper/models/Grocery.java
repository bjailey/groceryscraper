package uk.co.project.scraper.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Grocery {

	private String description;
	private String title;
	private BigDecimal unitPrice;
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Grocery)) return false;
		Grocery grocery = (Grocery) object;
		return Objects.equals(description, grocery.description) && Objects.equals(title, grocery.title) &
				Objects.equals(unitPrice, grocery.unitPrice);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(description, title, unitPrice);
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}