package projetomongo.converter;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class Converters extends AbstractMongoClientConfiguration {
	@Bean
	public MongoCustomConversions mongoCustomConversions() {
		return new MongoCustomConversions(Arrays.asList(new DoubletoNotaConverter(), new CursoToStringConverter(), new NotaToDoubleConverter()));
	}

	@Override
	protected String getDatabaseName() {
		return "test";
	}
	
	@Override
    protected boolean autoIndexCreation() {               
        return true;
    }
}
