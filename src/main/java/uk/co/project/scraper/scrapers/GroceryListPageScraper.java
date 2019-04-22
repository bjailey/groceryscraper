package uk.co.project.scraper.scrapers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.project.scraper.utils.JsoupWrapper;

@Component
public class GroceryListPageScraper {
	
	private JsoupWrapper jsoupWrapper;
	
	@Autowired
	public GroceryListPageScraper(JsoupWrapper jsoupWrapper) {
		this.jsoupWrapper = jsoupWrapper;
	}
	
	public List<String> getGroceryUrls(String url) {
		List<String> urls = new ArrayList<>();
		Consumer<Element> addUrlConsumer = element -> urls.add(
				element.select("div.productInfo")
					.select("div.productNameAndPromotions")
					.select("a")
					.first()
					.attr("abs:href"));
		Document document = jsoupWrapper.getDocument(url);
		Elements elements = document.select("div.product");
		elements.forEach(element -> addUrlConsumer.accept(element));
		return urls;
	}
}