package uk.co.project.scraper.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import uk.co.project.scraper.models.Grocery;
import uk.co.project.scraper.models.Total;

public abstract class TotalCalculator {
	
	public static Total getTotal(List<Grocery> groceries) {
		BigDecimal vatDivider = new BigDecimal(1.2);
		BigDecimal gross = new BigDecimal(0);
		for (Grocery grocery : groceries) {
			gross = gross.add(grocery.getUnitPrice());
		}
		BigDecimal vat = gross.divide(vatDivider, 2, RoundingMode.HALF_UP);
		return new Total(gross.setScale(2), vat);
	}
}