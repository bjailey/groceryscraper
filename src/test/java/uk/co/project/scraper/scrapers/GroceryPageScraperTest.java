package uk.co.project.scraper.scrapers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import uk.co.project.scraper.exceptions.HtmlSelectorException;
import uk.co.project.scraper.models.Grocery;
import uk.co.project.scraper.utils.JsoupWrapper;

public class GroceryPageScraperTest {

	Document mockDocument;
	Element mockElement;
	Elements mockElements;
	JsoupWrapper mockJsoupWrapper;
	GroceryPageScraper spyGroceryPageScraper;
	
	@Before
	public void setUp() {
		mockDocument = mock(Document.class);
		mockElement = mock(Element.class);
		mockElements = mock(Elements.class);
		mockJsoupWrapper = mock(JsoupWrapper.class);
		spyGroceryPageScraper = spy(new GroceryPageScraper(mockJsoupWrapper));
	}
	
	@Test
	public void testGetGroceryReturnsCorrectGrocery() {
		//Arrange
		String description = "description";
		Integer kcals = 1;
		String title = "title";
		BigDecimal unitPrice = new BigDecimal(1);
		Grocery expected = new Grocery();
		expected.setDescription(description);
		expected.setKcals(kcals);
		expected.setTitle(title);
		expected.setUnitPrice(unitPrice);
		
		//Act
		doReturn(mockDocument).when(mockJsoupWrapper).getDocument(any());
		doReturn(description).when(spyGroceryPageScraper).getGroceryDescription(any());
		doReturn(kcals).when(spyGroceryPageScraper).getGroceryKcals(any());
		doReturn(title).when(spyGroceryPageScraper).getGroceryTitle(any());
		doReturn(unitPrice).when(spyGroceryPageScraper).getGroceryUnitPrice(any());
		Grocery actual = spyGroceryPageScraper.getGrocery(any());

		//Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetGroceryDescriptionReturnsGroceryDescription() {
		//Arrange
		String expected = "description";
		
		//Act
		doReturn(mockElements).when(mockDocument).select(any());
		doReturn(mockElement).when(mockElements).first();
		doReturn(expected).when(mockElement).text();
		String actual = spyGroceryPageScraper.getGroceryDescription(mockDocument);
		
		//Assert
		assertEquals(expected, actual);
	}
	
	@Test(expected = HtmlSelectorException.class)
	public void testGetGroceryDescriptionThrowsHtmlSelectorExceptionWhenSelectedElementIsNull() {
		//Arrange
		
		//Act
		doReturn(mockElements).when(mockDocument).select(any());
		doReturn(null).when(mockElements).first();
		spyGroceryPageScraper.getGroceryDescription(mockDocument);
		
		//Assert
	}
	
	@Test
	public void testGetGroceryKcalsReturnsGroceryKcals() {
		//Arrange
		String kcalString = "1 kcal";
		Integer expected = 1;
		
		//Act
		doReturn(mockElements).when(mockDocument).select(any());
		doReturn(mockElement).when(mockElements).first();
		doReturn(kcalString).when(mockElement).text();
		Integer actual = spyGroceryPageScraper.getGroceryKcals(mockDocument);
		
		//Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetGroceryKcalsReturnsNullWhenElementIsNull() {
		//Arrange
		
		//Act
		doReturn(mockElements).when(mockDocument).select(any());
		doReturn(null).when(mockElements).first();
		Integer result = spyGroceryPageScraper.getGroceryKcals(mockDocument);
		
		//Assert
		assertNull(result);
	}
	
	@Test
	public void testGetGroceryTitleReturnsGroceryTitle() {
		//Arrange
		String expected = "title";
		
		//Act
		doReturn(mockElements).when(mockDocument).select(any());
		doReturn(mockElement).when(mockElements).first();
		doReturn(expected).when(mockElement).text();
		String actual = spyGroceryPageScraper.getGroceryTitle(mockDocument);
		
		//Assert
		assertEquals(expected, actual);
	}
	
	@Test(expected = HtmlSelectorException.class)
	public void testGetGroceryTitleThrowsHtmlSelectorExceptionWhenSelectedElementIsNull() {
		//Arrange
		
		//Act
		doReturn(mockElements).when(mockDocument).select(any());
		doReturn(null).when(mockElements).first();
		spyGroceryPageScraper.getGroceryTitle(mockDocument);
		
		//Assert
	}
	
	@Test
	public void testGetGroceryUnitPriceReturnsGroceryUnitPrice() {
		//Arrange
		String text = "£3.00";
		BigDecimal expected = new BigDecimal("3.00");
		
		//Act
		doReturn(mockElements).when(mockDocument).getElementsByClass(any());
		doReturn(mockElement).when(mockElements).first();
		doReturn(text).when(mockElement).text();
		BigDecimal actual = spyGroceryPageScraper.getGroceryUnitPrice(mockDocument);
		
		//Assert
		assertEquals(expected, actual);
	}
	
	@Test(expected = HtmlSelectorException.class)
	public void testGetGroceryUnitPriceThrowsHtmlSelectorExceptionWhenSelectedElementIsNull() {
		//Arrange
		
		//Act
		doReturn(mockElements).when(mockDocument).getElementsByClass(any());
		doReturn(null).when(mockElements).first();
		spyGroceryPageScraper.getGroceryUnitPrice(mockDocument);
		
		//Assert
	}
}