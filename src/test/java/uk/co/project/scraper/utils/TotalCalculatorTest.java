package uk.co.project.scraper.utils;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import uk.co.project.scraper.models.Grocery;
import uk.co.project.scraper.models.Total;

public class TotalCalculatorTest {

	@Test
	public void testGetTotalReturnsCorrectTotal() {
		//Arrange
		BigDecimal price = new BigDecimal(1);
		Grocery groceryOne = new Grocery();
		groceryOne.setUnitPrice(price);
		Grocery groceryTwo = new Grocery();
		groceryTwo.setUnitPrice(price);
		List<Grocery> groceries = Arrays.asList(groceryOne, groceryTwo);
		BigDecimal expectedGross = new BigDecimal(2).setScale(2);
		BigDecimal expectedVat = new BigDecimal(1.67).setScale(2, RoundingMode.HALF_UP);
		Total expected = new Total(expectedGross, expectedVat);
		
		//Act
		Total actual = TotalCalculator.getTotal(groceries);

		//Assert
		assertEquals(expected, actual);
	}
}