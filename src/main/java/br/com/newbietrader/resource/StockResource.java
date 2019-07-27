package br.com.newbietrader.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.newbietrader.dto.StockDTO;
import br.com.newbietrader.service.StockService;

@Path("/stocks")
@Produces(MediaType.APPLICATION_JSON)
public class StockResource {

	@Inject
	private StockService stockService;
	
    @GET
    public List<StockDTO> findAll() {
        return stockService.findAll();
    }
}