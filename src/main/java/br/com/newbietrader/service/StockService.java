package br.com.newbietrader.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.newbietrader.dto.StockDTO;
import br.com.newbietrader.dto.StockValueDTO;

@ApplicationScoped
public class StockService {

	private List<StockDTO> database = new ArrayList<>();

	public StockService() {
		
		StockValueDTO valueDTO = new StockValueDTO();
		valueDTO.setStart(BigDecimal.ONE);
		valueDTO.setEnd(BigDecimal.TEN);
		
		StockDTO dto = new StockDTO();
		
		dto.setName("PETR4");
		dto.setDate(LocalDate.now());
		dto.setValue(valueDTO);
		
		database.add(dto);
		database.add(dto);
		database.add(dto);
		database.add(dto);
	}

	public List<StockDTO> findAll() {
		
		return database;
	}
	
	
	
}
