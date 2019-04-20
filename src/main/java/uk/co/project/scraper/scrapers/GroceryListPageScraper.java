package uk.co.project.scraper.scrapers;

public class GroceryListPageScraper {
	
	private String url;
	
	public GroceryListPageScraper(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
}