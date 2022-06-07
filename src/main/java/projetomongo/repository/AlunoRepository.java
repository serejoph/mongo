package projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import projetomongo.model.Aluno;


public interface AlunoRepository extends MongoRepository<Aluno, String>{

	
	
}
