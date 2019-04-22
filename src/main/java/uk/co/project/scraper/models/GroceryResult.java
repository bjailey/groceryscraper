package uk.co.project.scraper.models;

import java.util.List;
import java.util.Objects;

public class GroceryResult {
	
	private List<Grocery> results;
	private Total total;
	
	public GroceryResult(List<Grocery> results, Total total) {
		this.results = results;
		this.total = total;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof GroceryResult)) return false;
		GroceryResult groceryResult = (GroceryResult) object;
		return Objects.equals(results, groceryResult.results) && Objects.equals(total, groceryResult.total);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(results, total);
	}

	public List<Grocery> getResults() {
		return results;
	}
	
	public Total getTotal() {
		return total;
	}
	
	public void setResults(List<Grocery> results) {
		this.results = results;
	}
	
	public void setTotal(Total total) {
		this.total = total;
	}	
}