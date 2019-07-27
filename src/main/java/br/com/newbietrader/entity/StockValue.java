package br.com.newbietrader.entity;

import java.math.BigDecimal;

public class StockValue {

	private BigDecimal start;
	private BigDecimal end;
	
	private StockValue(BigDecimal start, BigDecimal end) {
		this.start = start;
		this.end = end;
	}

	public static StockValue of(BigDecimal start, BigDecimal end) {
		return new StockValue(start, end);
	}
	
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
}
