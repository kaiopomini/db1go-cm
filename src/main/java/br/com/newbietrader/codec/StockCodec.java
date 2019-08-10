package br.com.newbietrader.codec;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.Decimal128;

import com.mongodb.MongoClient;


import br.com.newbietrader.entity.Stock;
import br.com.newbietrader.entity.StockValue;

public class StockCodec implements CollectibleCodec<Stock> {

	
	
	private final Codec<Document> documentCodec;

    public StockCodec() {
        this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
    }


	@Override
	public void encode(BsonWriter writer, Stock entity, EncoderContext encoderContext) {
		Document doc = new Document();
        doc.put("name", entity.getName());
        doc.put("date", entity.getDate());
        Document valueDoc = new Document();
        valueDoc.put("start", entity.getValue().getStart());
        valueDoc.put("end", entity.getValue().getEnd());
        doc.put("value", valueDoc);
        documentCodec.encode(writer, doc, encoderContext);

	}

	@Override
	public Class<Stock> getEncoderClass() {
		
		return Stock.class;
	}

	@Override
	public Stock decode(BsonReader reader, DecoderContext decoderContext) {
		Document doc = documentCodec.decode(reader, decoderContext);
		Stock stock = new Stock();
		stock.setName(doc.getString("name"));
		//stock.setDate(LocalDate.parse(doc.getString("date")));
		
		stock.setDate(doc.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); //solução - mesmo erro do cris
		
		
		
		Document valueDoc = doc.get("value", Document.class);
		
		//BigDecimal start = BigDecimal.valueOf(valueDoc.getDouble("start"));
		//BigDecimal end = BigDecimal.valueOf(valueDoc.getDouble("end"));
		
		BigDecimal start = valueDoc.get("start", Decimal128.class).bigDecimalValue(); //solução - mesmo erro do cris
		BigDecimal end = valueDoc.get("end", Decimal128.class).bigDecimalValue(); //solução - mesmo erro do cris
		
		
		StockValue stockValue = StockValue.of(start, end);
		stock.setValue(stockValue);
		
		
			
		return stock;
	}

	@Override
	public Stock generateIdIfAbsentFromDocument(Stock document) {
		
		return document;
	}

	@Override
	public boolean documentHasId(Stock document) {
		
		return false;
	}

	@Override
	public BsonValue getDocumentId(Stock document) {
		
		return null;
	}
}