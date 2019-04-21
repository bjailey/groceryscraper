package uk.co.project.scraper.utils;

import org.junit.Before;
import org.junit.Test;

import uk.co.project.exceptions.JsoupException;

public class JsoupWrapperTest {

	JsoupWrapper jsoupWrapper;
	
	@Before
	public void setUp() {
		this.jsoupWrapper = new JsoupWrapper();
	}
	
	@Test(expected = JsoupException.class)
	public void testGetDocumentThrowsJsoupExceptionWhenJsoupCannotConnectToUrl() {
		//Arrange
		
		//Act
		jsoupWrapper.getDocument(null);
		
		//Assert
	}
}