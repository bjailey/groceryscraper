package uk.co.project.scraper.models;

import java.util.List;

public class GroceryResult {

	private List<Grocery> results;
	private Total total;
	
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