package projetomongo.converter;

import org.springframework.core.convert.converter.Converter;

import projetomongo.model.Curso;

public class CursoToStringConverter implements Converter<Curso, String> {

	@Override
	public String convert(Curso curso) {
		return curso.getNome();
	}

}
