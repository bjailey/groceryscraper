package uk.co.project.scraper.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Total {

	private BigDecimal gross;
	private BigDecimal vat;
	
	public Total(BigDecimal gross, BigDecimal vat) {
		this.gross = gross;
		this.vat = vat;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Total)) return false;
		Total total = (Total) object;
		return Objects.equals(gross, total.gross) && Objects.equals(vat, total.vat);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(gross, vat);
	}

	public BigDecimal getGross() {
		return gross;
	}
	
	public BigDecimal getVat() {
		return vat;
	}
}