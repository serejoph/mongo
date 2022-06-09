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

import projetomongo.controller.dto.NotaDto;
import projetomongo.service.AlunoService;

@Controller
@RequestMapping("notas")
public class NotasController {
	
	@Autowired
	AlunoService alunoService;

	@GetMapping("/cadastrar/{id}")
	public String telaDeCadastro(@PathVariable String id, Model model, NotaDto notaDto) {
		
		model.addAttribute("aluno", alunoService.findById(id));
		return "notas/cadastrar";
	}
	

	@PostMapping("/cadastrar/{id}")
	public String cadastrarNota(@Valid NotaDto notaDto, BindingResult result, @PathVariable String id, Model model) {
		model.addAttribute("aluno", alunoService.findById(id));
		if (result.hasErrors()) return "notas/cadastrar";
		
		alunoService.salvarNota(id, notaDto);
		
		return "redirect:/aluno/listar";
	}


}
