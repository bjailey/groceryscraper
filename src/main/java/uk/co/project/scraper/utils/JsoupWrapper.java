package uk.co.project.scraper.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import uk.co.project.scraper.exceptions.JsoupException;

@Component
public class JsoupWrapper {

	public Document getDocument(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (Exception e) {
			throw new JsoupException(url);
		}
	}
}