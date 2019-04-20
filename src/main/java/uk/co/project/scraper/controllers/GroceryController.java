package uk.co.project.scraper.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.project.scraper.models.Grocery;
import uk.co.project.scraper.models.GroceryResult;
import uk.co.project.scraper.models.Total;
import uk.co.project.scraper.scrapers.GroceryListPageScraper;
import uk.co.project.scraper.scrapers.GroceryPageScraper;
import uk.co.project.scraper.utils.TotalCalculator;

@Component
public class GroceryController {

	private static final String LIST_PAGE_URL = "https://jsainsburyplc.github.io/serverside-test/site/"
			+ "www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
	private GroceryListPageScraper groceryListPageScraper;
	private GroceryPageScraper groceryPageScraper;
	
	@Autowired
	public GroceryController(GroceryListPageScraper groceryListPageScraper,
			GroceryPageScraper groceryPageScraper) {
		this.groceryListPageScraper = groceryListPageScraper;
		this.groceryPageScraper = groceryPageScraper;
	}
	
	public GroceryResult getGroceryResult() {
		List<Grocery> groceries = new ArrayList<>();
		List<String> urls = groceryListPageScraper.getGroceryUrls(LIST_PAGE_URL);
		urls.forEach(url -> groceries.add(groceryPageScraper.getGrocery(url)));
		Total total = TotalCalculator.getTotal(groceries);
		return new GroceryResult(groceries, total);
	}
}