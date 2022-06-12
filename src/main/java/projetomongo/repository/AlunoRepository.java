package projetomongo.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import projetomongo.model.Aluno;


public interface AlunoRepository extends MongoRepository<Aluno, String>{

	List<Aluno> findByNome(String nome);

	@Query("{notas: {$gte : [?0]}}")
	List<Aluno> findAprovados(Double nota);

	@Query("{notas: {$lt : [?0]}}")
	List<Aluno> findReprovados(Double nota);
	
	List<Aluno> findByLocalizacaoNear(Point location, Distance distance);
}
