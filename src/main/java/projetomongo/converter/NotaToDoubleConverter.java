package projetomongo.converter;

import org.springframework.core.convert.converter.Converter;

import projetomongo.model.Nota;

public class NotaToDoubleConverter implements Converter<Nota, Double> {

	@Override
	public Double convert(Nota nota) {
	
		return nota.getValor();
	}

}
