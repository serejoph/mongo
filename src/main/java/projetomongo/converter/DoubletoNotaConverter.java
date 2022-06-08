package projetomongo.converter;

import org.springframework.core.convert.converter.Converter;

import projetomongo.model.Nota;

public class DoubletoNotaConverter implements Converter<Double, Nota> {

	@Override
	public Nota convert(Double source) {
		Nota n = new Nota();
		n.setValor(source);
		return n;
	}

}
