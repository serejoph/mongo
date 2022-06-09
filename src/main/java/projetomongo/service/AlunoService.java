package projetomongo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import projetomongo.controller.dto.HabilidadeDto;
import projetomongo.controller.dto.NotaDto;
import projetomongo.controller.dto.UserDto;
import projetomongo.model.Aluno;
import projetomongo.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}

	public void cadastrar(UserDto dto) {
		alunoRepository.save(dto.toAluno());	
		
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
	
	
}
