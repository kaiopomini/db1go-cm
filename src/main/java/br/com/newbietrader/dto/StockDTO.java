package br.com.newbietrader.dto;

import java.time.LocalDate;

public class StockDTO {

	private String name;
	private LocalDate date;
	private StockValueDTO value;
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setValue(StockValueDTO value) {
		this.value = value;
	}
	

	public String getName() {
		return name;
	}

	public LocalDate getDate() {
		return date;
	}

	public StockValueDTO getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name + " - " + date + " - " + value;
	}
	
}
