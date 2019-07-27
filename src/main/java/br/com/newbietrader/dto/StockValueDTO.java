package br.com.newbietrader.dto;

import java.math.BigDecimal;

public class StockValueDTO {

	private BigDecimal start;
	private BigDecimal end;
	
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
	public BigDecimal getStart() {
		return start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	@Override
	public String toString() {
		return "Start: " + start + " End: " + end;
	}
}
