package br.com.newbietrader.entity;

import java.time.LocalDate;

public class Stock {

	private String name;
	private LocalDate date;
	private StockValue value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public StockValue getValue() {
		return value;
	}
	public void setValue(StockValue value) {
		this.value = value;
	}
	
}
