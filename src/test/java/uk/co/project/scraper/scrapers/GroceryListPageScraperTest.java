package uk.co.project.scraper.scrapers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import uk.co.project.scraper.utils.JsoupWrapper;

public class GroceryListPageScraperTest {

	JsoupWrapper mockJsoupWrapper;
	GroceryListPageScraper groceryListPageScraper;
	
	@Before
	public void setUp() {
		mockJsoupWrapper = mock(JsoupWrapper.class);
		groceryListPageScraper = new GroceryListPageScraper(mockJsoupWrapper);
	}
	
	@Test
	public void testGetGroceryUrlsGetsGroceryUrls() {
		//Arrange
		String url = "url";
		Document mockDocument = mock(Document.class);
		Elements mockElements = mock(Elements.class);
		Element mockElement = mock(Element.class);
		Elements elements = new Elements();
		elements.add(mockElement);
		List<String> expected = Arrays.asList(url);
		
		//Act
		doReturn(mockDocument).when(mockJsoupWrapper).getDocument(any());
		doReturn(elements).when(mockDocument).select(any());
		doReturn(mockElements).when(mockElement).select(any());
		doReturn(mockElements).when(mockElements).select(any());
		doReturn(mockElement).when(mockElements).first();
		doReturn(url).when(mockElement).attr(any());
		List<String> actual = groceryListPageScraper.getGroceryUrls(any());
		
		//Assert
		assertEquals(expected, actual);
	}
	
}