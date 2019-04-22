package uk.co.project.scraper.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.co.project.scraper.models.Grocery;
import uk.co.project.scraper.models.GroceryResult;
import uk.co.project.scraper.models.Total;
import uk.co.project.scraper.scrapers.GroceryListPageScraper;
import uk.co.project.scraper.scrapers.GroceryPageScraper;

public class GroceryControllerTest {

	GroceryListPageScraper mockGroceryListPageScraper;
	GroceryPageScraper mockGroceryPageScraper;
	GroceryController groceryController;
	
	@Before
	public void setUp() {
		mockGroceryListPageScraper = mock(GroceryListPageScraper.class);
		mockGroceryPageScraper = mock(GroceryPageScraper.class);
		groceryController = new GroceryController(mockGroceryListPageScraper, mockGroceryPageScraper);
	}
	
	@Test
	public void testGetGroceryResultGetsCorrectGroceryResult() {
		//Arrange
		Grocery grocery = new Grocery();
		grocery.setUnitPrice(new BigDecimal(1));
		List<Grocery> groceries = Arrays.asList(grocery, grocery);
		List<String> urls = Arrays.asList("", "");
		BigDecimal expectedGross = new BigDecimal(2).setScale(2);
		BigDecimal expectedVat = new BigDecimal(0.33).setScale(2, RoundingMode.HALF_UP);
		Total total = new Total(expectedGross, expectedVat);
		GroceryResult expected = new GroceryResult(groceries, total);
		
		//Act
		doReturn(urls).when(mockGroceryListPageScraper).getGroceryUrls(any());
		doReturn(grocery).when(mockGroceryPageScraper).getGrocery(any());
		GroceryResult actual = groceryController.getGroceryResult();

		//Assert
		assertEquals(expected, actual);
	}
}