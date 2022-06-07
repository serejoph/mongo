package projetomongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projetomongo.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Model model) {
		
		model.addAttribute("alunos", alunoService.findAll());
		return "aluno/cadastrar";
	}
	
}
