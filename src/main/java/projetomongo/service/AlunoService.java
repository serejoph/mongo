package projetomongo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;

import projetomongo.dto.HabilidadeDto;
import projetomongo.dto.NotaDto;
import projetomongo.enums.Corte;
import projetomongo.model.Aluno;
import projetomongo.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	@Autowired
	LocalizacaoService localizacaoService;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public void cadastrar(Aluno aluno) {
		try {
			System.out.println("pré excep");
			Double[] latLng = localizacaoService.getLatLong(aluno.getLocalizacao());
			System.out.println("post");
			aluno.getLocalizacao().setCoordinates(latLng);
			alunoRepository.save(aluno);

		} catch (ApiException | InterruptedException | IOException e) {
			e.printStackTrace();
		}

	}

	public Aluno findById(String id) {
		Optional<Aluno> alunoOpt = alunoRepository.findById(id);
		return alunoOpt.isPresent() ? alunoOpt.get() : new Aluno();
	}

	public void cadastrarHabilidade(String id, @Valid HabilidadeDto habilidadeDto) {
		Aluno aluno = alunoRepository.findById(id).get();
		aluno.getHabilidades().add(habilidadeDto.toHabilidade());
		alunoRepository.save(aluno);

	}

	public void salvarNota(String id, NotaDto notaDto) {
		Aluno aluno = alunoRepository.findById(id).get();
		aluno.getNotas().add(notaDto.toNota());
		alunoRepository.save(aluno);

	}

	public List<Aluno> findByNome(String name) {
		return alunoRepository.findByNome(name);

	}

	public List<Aluno> findByName(String nome) {
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		ExampleMatcher matcher = ExampleMatcher.matching();
		matcher = matcher.withIgnorePaths("notas", "habilidades").withStringMatcher(StringMatcher.CONTAINING);
		List<Aluno> findAll = alunoRepository.findAll(Example.of(aluno, matcher));
		findAll.forEach(System.out::println);
		System.out.println("printeiall");
		return findAll;
	}

	public Object findByNota(String nota, Corte corte) {
		try {
			if (corte == Corte.APROVADOS)
				return alunoRepository.findAprovados(Double.parseDouble(nota));
			return alunoRepository.findReprovados(Double.parseDouble(nota));
		} catch (NullPointerException | NumberFormatException e) {
			return new ArrayList<>();
		}
	}

	public List<Aluno> findNear(String id) {
		Optional<Aluno> alunoOpt = alunoRepository.findById(id);
		if (alunoOpt.isEmpty()) return new ArrayList<>();
		Aluno aluno = alunoOpt.get();
		Double[] coordenadas = aluno.getLocalizacao().getCoordinates();
		Point point = new Point(coordenadas[0], coordenadas[1]);
		Distance d = new Distance(5, Metrics.KILOMETERS);
		return alunoRepository.findByLocalizacaoNear(point, d);
	}

}
