package projetomongo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetomongo.model.Aluno;
import projetomongo.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoApi {

	@Autowired
	AlunoService alunoService;
	
	@CrossOrigin
	@GetMapping("/alunos")
	public ResponseEntity<List<Aluno>> getAlunos(){
		return ResponseEntity.ok(alunoService.findAll());
	}
	
}
