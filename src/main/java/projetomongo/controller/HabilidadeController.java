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

import projetomongo.controller.dto.HabilidadeDto;
import projetomongo.service.AlunoService;

@Controller
@RequestMapping("/habilidades")
public class HabilidadeController {

	@Autowired
	AlunoService alunoService;
	
	@GetMapping("/cadastrar/{id}")
	public String telaDeCadastro(@PathVariable(name = "id") String id, Model model, HabilidadeDto habilidadeDto) {
		model.addAttribute("aluno", alunoService.findById(id));
		return "habilidades/cadastrar";
	}
	
	@PostMapping("/cadastrar/{id}")
	public String cadastrarHabilidade(@Valid HabilidadeDto habilidadeDto, BindingResult result, @PathVariable(name = "id") String id, Model model) {
		model.addAttribute("aluno", alunoService.findById(id));
		if (result.hasErrors()) return "habilidades/cadastrar";
		
		alunoService.cadastrarHabilidade(id, habilidadeDto);
		
		return "redirect:/aluno/listar";
	}
	
}
