package uk.co.project.scraper.scrapers;

import java.math.BigDecimal;
import java.util.Optional;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.project.scraper.exceptions.HtmlSelectorException;
import uk.co.project.scraper.models.Grocery;
import uk.co.project.scraper.utils.JsoupWrapper;

@Component
public class GroceryPageScraper {

	private JsoupWrapper jsoupWrapper;
	
	@Autowired
	public GroceryPageScraper(JsoupWrapper jsoupWrapper) {
		this.jsoupWrapper = jsoupWrapper;
	}
	
	public Grocery getGrocery(String url) {
		Document document = jsoupWrapper.getDocument(url);
		Grocery grocery = new Grocery();
		grocery.setDescription(getGroceryDescription(document));
		grocery.setKcals(getGroceryKcals(document));
		grocery.setTitle(getGroceryTitle(document));
		grocery.setUnitPrice(getGroceryUnitPrice(document));
		return grocery;
	}
	
	String getGroceryDescription(Document document) {
		String selector = "div.productText p";
		Optional<Element> optElement = Optional.ofNullable(document.select(selector).first());
		return optElement.orElseThrow(() -> new HtmlSelectorException(selector)).text();
	}
	
	Integer getGroceryKcals(Document document) {
		String selector = "table.nutritionTable tbody tr td";
		Element element = document.select(selector).first();
		return (element != null) ? Integer.parseInt(element.text().replaceAll("[^\\d,]", "").trim()) : null;
	}
	
	String getGroceryTitle(Document document) {
		String selector = ".productTitleDescriptionContainer h1";
		Optional<Element> optElement = Optional.ofNullable(
				document.select(selector).first());
		return optElement.orElseThrow(() -> new HtmlSelectorException(selector)).text();
	}
	
	BigDecimal getGroceryUnitPrice(Document document) {
		String className = "pricePerUnit";
		Optional<Element> optElement = Optional.ofNullable(document.getElementsByClass(className).first());
		Element element = optElement.orElseThrow(() -> new HtmlSelectorException(className));
		return new BigDecimal(element.text().replaceAll("[^\\d.,]", ""));
	}
}