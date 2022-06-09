package projetomongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import projetomongo.model.Aluno;


public interface AlunoRepository extends MongoRepository<Aluno, String>{

	List<Aluno> findByNome(String nome);
	
	
}
