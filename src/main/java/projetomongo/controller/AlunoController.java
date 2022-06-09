package projetomongo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projetomongo.controller.dto.UserDto;
import projetomongo.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
	@GetMapping("/cadastrar")
	public String telaDeCadastro(UserDto aluno, Model model) {		
		return "aluno/cadastrar";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarUsuario(@Valid UserDto dto, BindingResult res, Model model) {
		if(res.hasErrors()) {
			return "aluno/cadastrar";
		}
		
		alunoService.cadastrar(dto);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/listar")
	public String listarAlunos(Model model) {
		model.addAttribute("alunos", alunoService.findAll());
		return "aluno/listar";
	}
	
	@GetMapping("/visualizar/{id}")
	public String visualizar(@PathVariable String id, Model model) {
		
		model.addAttribute("aluno", alunoService.findById(id));
		return "/aluno/visualizar";
		
		
	}
	
}
