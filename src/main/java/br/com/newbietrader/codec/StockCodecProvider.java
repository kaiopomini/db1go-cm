package br.com.newbietrader.codec;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

import br.com.newbietrader.entity.Stock;


public class StockCodecProvider implements CodecProvider {

	@Override
	public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
		
		if (clazz == Stock.class) {
            return (Codec<T>) new StockCodec();
        }
		
        return null;
	
	}
	
}
