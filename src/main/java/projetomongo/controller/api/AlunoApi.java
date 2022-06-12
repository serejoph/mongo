package projetomongo.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetomongo.dto.LocalizacaoDto;
import projetomongo.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoApi {

	@Autowired
	AlunoService alunoService;
	
	@CrossOrigin
	@GetMapping("/alunos")
	public ResponseEntity<List<LocalizacaoDto>> getAlunos(String id){
		
		System.out.println("id = "+id);
		return ResponseEntity.ok(alunoService.findAll().stream().map(x -> new LocalizacaoDto(x)).collect(Collectors.toList()));
	}
	
	@PostMapping("/alunos")
	public ResponseEntity<List<LocalizacaoDto>> postAlunos(@RequestBody String id){		
		System.out.println(id);
		return ResponseEntity.ok(alunoService.findNear(id).stream().map(x -> new LocalizacaoDto(x)).collect(Collectors.toList()));
	}
	
	
}
