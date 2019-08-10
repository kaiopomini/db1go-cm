package br.com.newbietrader.repository;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import br.com.newbietrader.entity.Stock;



@ApplicationScoped
public class StockRepository {
	
	@Inject 
	private MongoClient mongoClient;

	public List<Stock> findAll() {
		MongoCollection<Stock> collection = getCollection();
		
		List<Stock> result = new LinkedList<Stock>();
		
		for (Stock doc : collection.find()) {
				
			result.add(doc);
			
		}
		return result;
	}
	
	private MongoCollection<Stock> getCollection() {
		return mongoClient.getDatabase("db1go").getCollection("stocks", Stock.class);
	}

	public void save(Stock stock) {
		getCollection().insertOne(stock);
		
	}

}
