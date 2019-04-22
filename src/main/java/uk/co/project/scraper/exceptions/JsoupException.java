package uk.co.project.scraper.exceptions;

public class JsoupException extends RuntimeException {
	
	private static final long serialVersionUID = -473245433000501151L;
	private String message;
	
	public JsoupException(String url) {
		this.message = "Error getting Document from url: " + url;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}