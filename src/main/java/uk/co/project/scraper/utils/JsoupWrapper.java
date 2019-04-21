package uk.co.project.scraper.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import uk.co.project.exceptions.JsoupException;

@Component
public class JsoupWrapper {

	public Document getDocument(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			JsoupException jsoupException = new JsoupException();
			jsoupException.setStackTrace(e.getStackTrace());
			throw jsoupException;
		}
	}
}