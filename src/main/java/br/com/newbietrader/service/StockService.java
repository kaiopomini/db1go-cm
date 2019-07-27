package br.com.newbietrader.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.newbietrader.adapter.StockAdapter;
import br.com.newbietrader.dto.StockDTO;
import br.com.newbietrader.repository.StockRepository;

@ApplicationScoped
public class StockService {

	@Inject
	private StockRepository stockRepository;;
	
	public List<StockDTO> findAll() {
		
		return stockRepository.findAll().stream()
				.map(StockAdapter::toDTO)
				.collect(Collectors.toList());
	}
	
	
	
}
