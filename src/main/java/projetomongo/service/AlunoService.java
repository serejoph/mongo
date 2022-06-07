package projetomongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetomongo.model.Aluno;
import projetomongo.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
}
