package uk.co.project.scraper.exceptions;

public class HtmlSelectorException extends RuntimeException {

	private static final long serialVersionUID = -5781563557485113804L;
	private String message;
	
	public HtmlSelectorException(String selector) {
		this.message = "Error finding element using selector: " + selector;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}